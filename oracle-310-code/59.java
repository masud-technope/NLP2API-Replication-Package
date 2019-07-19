package org.kodejava.example.awt;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RunningDefaultAppPrint {
    public static void main(String[] args) {
        File file = new File("data.txt");
        try {
            Desktop desktop = Desktop.getDesktop();

            //
            // Prints a file with the native desktop printing
            // facility, using the associated application's
            // print command.
            //
            desktop.print(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}