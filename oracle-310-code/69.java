package com.javadb.examples;
 
import java.lang.reflect.Method;
 
/**
 *
 * @author www.javadb.com 
 */
public class Main {
 
    public void loadClass() {
        try {
 
            Class myclass = Class.forName(getClassName());
 
            //Use reflection to list methods and invoke them
            Method[] methods = myclass.getMethods();
            Object obj = myclass.newInstance();
 
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().startsWith("say")) {
                    System.out.println(methods[i].invoke(obj));
                }
 
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
    private String getClassName() {
 
        //Do appropriate stuff here to find out the classname
 
        return "com.javadb.examples.MyClass";
    }
 
    public static void main(String[] args) {
        new Main().loadClass();
    }
}