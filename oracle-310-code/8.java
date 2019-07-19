package org.kodejava.example.mongodb;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

public class MongoDBConnect {
    public static void main(String[] args) {
        try {
            MongoClient client =
                    new MongoClient(new ServerAddress("localhost", 27017));

            DB database = client.getDB("school");
            DBCollection students = database.getCollection("students");
            students.remove(new BasicDBObject());

            String[] types = {"Homework", "Quiz", "Essay"};
            for (int i = 1; i <= 10; i++) {
                for (int j = 0; j < 3; j++) {
                    students.insert(new BasicDBObject("student_id", i)
                            .append("type", types[j])
                            .append("score", new Random().nextInt(100)));
                }
            }

            try (DBCursor cursor = students.find()) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}