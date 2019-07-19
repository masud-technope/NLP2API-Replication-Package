package org.kodejava.example.logging;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class RollingLogFile {
    //
    // Set a small log file size to demonstrate the rolling log files.
    //
    public static final int FILE_SIZE = 1024;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(RollingLogFile.class.getName());

        try {
            //
            // Creating an instance of FileHandler with 5 logging files
            // sequences.
            //
            FileHandler handler = new FileHandler("myapp.log", FILE_SIZE, 5, true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            logger.warning("Failed to initialize logger handler.");
        }

        logger.info("Logging information message.");
        logger.warning("Logging warning message.");
    }
}
