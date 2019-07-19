package com.javadb.examples;
 
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
 
 
/**
 *
 * @author www.javadb.com 
 */
public class Main {
    
    public void loadResourceBundle() {
        
        ResourceBundle resource = ResourceBundle.getBundle("Phrases", Locale.US);
        
        Enumeration<String> keys = resource.getKeys();
        
        String key = null;
        while (keys.hasMoreElements()) {
            
            key = keys.nextElement();
            
            System.out.println(key + " - " + resource.getObject(key));
        }
    }
 
 
    public static void main(String[] args) {
 
        new Main().loadResourceBundle();
    }
 
 }