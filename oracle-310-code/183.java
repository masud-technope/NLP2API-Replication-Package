package org.kodejava.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

public class UnzipObjectDemo {
    public static void main(String[] args) {
        User admin = null;
        User foo = null;

        try {
            FileInputStream fis = new FileInputStream(new File("user.dat"));
            GZIPInputStream gis = new GZIPInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(gis);

            admin = (User) ois.readObject();
            foo = (User) ois.readObject();

            ois.close();
            gis.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Admin = [" + admin + "]");
        System.out.println("Foo = [" + foo + "]");
    }
}
