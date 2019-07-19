package org.kodejava.example.util.logging;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.io.IOException;

public class LogFileLimit {
    //
    // The log file size is set to 1MB.
    //
    public static final int FILE_SIZE = 1024 * 1024;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LogFileLimit.class.getName());

        try {
            //
            // Create a FileHandler with 1MB file size and a single log file. We
			// also tell the handler to append the log message.
            //
            FileHandler handler = new FileHandler("myapp.log", FILE_SIZE, 1, true);
            logger.addHandler(handler);
        } catch (IOException e) {
            logger.warning("Failed to initialize logger handler.");
        }

        logger.info("Test info");
        logger.warning("Test warning");
        logger.severe("Test severe");
    }
}
