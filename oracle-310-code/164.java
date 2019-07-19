package com.javacodegeeks.snippets.enterprise;

import java.lang.management.ManagementFactory;

import javax.management.Attribute;
import javax.management.AttributeChangeNotification;
import javax.management.MBeanServer;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationListener;
import javax.management.ObjectName;

public class SendNotificationAtMBeanAttributeChange {
	
	public static void main(String[] args) throws Exception {
		
		String objectName = "com.javacodegeeks.snippets.enterprise:type=Hello";
		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();

	    // Construct the ObjectName for the Hello MBean we will register
	    ObjectName mbeanName = new ObjectName(objectName);
	    
	    Hello mbean = new Hello();
	    
	    server.registerMBean(mbean, mbeanName);
	    
	    // print the default message
	    String currentMessage = (String) server.getAttribute(mbeanName, "Message");
	    System.out.println("Current Message: " + currentMessage);
	    
	    // change the attribute value
	    String newMessage = "Hello Java Code Geeks";
	    server.setAttribute(mbeanName, new Attribute("Message", newMessage));
	    
	    // print the new message
	    currentMessage = (String) server.getAttribute(mbeanName, "Message");
	    System.out.println("Current Message: " + currentMessage);
		
	}
	
	public static class Hello extends NotificationBroadcasterSupport implements HelloMBean {
		
		private long sequenceNumber = 1;
		private String message = "Hello World";
		
		public Hello() {
			addNotificationListener(new NotificationListener() {
				@Override
				public void handleNotification(Notification notification, Object handback) {
					System.out.println("*** Handling new notification ***");
					System.out.println("Message: " + notification.getMessage());
					System.out.println("Seq: " + notification.getSequenceNumber());
					System.out.println("*********************************");
				}
			}, null, null);
		}

		@Override
		public String getMessage() {
			return this.message;
		}

		@Override
		public void sayHello() {
			System.out.println(message);
		}

		@Override
		public void setMessage(String message) {
			String oldMessage = this.message;
			this.message = message;
			Notification n = new AttributeChangeNotification(this, sequenceNumber++,
			
  System.currentTimeMillis(), "Message changed", "Message", "String",
			
  oldMessage, this.message);
			sendNotification(n);
		}
		
	}
	
	public static interface HelloMBean {
		
		// operations
		
		public void sayHello();

		// attributes
		
		// a read-write attribute called Message of type String
		public String getMessage();
		public void setMessage(String message);
		
	}

}
