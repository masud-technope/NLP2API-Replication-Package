package org.kodejava.example.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.Arrays;

public class MongoDBDocument {
    public static void main(String[] args) {

        // Creates an empty document.
        DBObject emptyDoc = new BasicDBObject();
        System.out.println("emptyDoc = " + emptyDoc);

        // Creates a simple document with a given key and value.
        DBObject simpleDoc = new BasicDBObject("name", "John Doe");
        System.out.println("simpleDoc = " + simpleDoc);

        // Creates a document with embedded document and arrays.
        DBObject document = new BasicDBObject("firstName", "Foo")
                .append("lastName", "Bar")
                .append("age", 25)
                .append("email", "foo@bar.com")
                .append("address",
                        new BasicDBObject("street", "Sunset Boulevard 123")
                                .append("city", "New York")
                                .append("country", "USA"))
                .append("hobbies", Arrays.asList("Swimming", "Cycling", "Running"));
        System.out.println("document = " + document);
    }
}