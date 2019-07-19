package org.kodejava.example.util.logging;

import java.util.logging.Logger;
import java.util.logging.Level;

public class LoggerGetLevel {
    private static Logger logger = Logger.getLogger(LoggerGetLevel.class.getName());

    public static void main(String[] args) {
        LoggerGetLevel demo = new LoggerGetLevel();
        System.out.println("demo.getLevel(logger) = " + demo.getLevel(logger));

        logger.setLevel(Level.WARNING);
        System.out.println("demo.getLevel(logger) = " + demo.getLevel(logger));
    }

    public Level getLevel(Logger logger) {
        Level level = logger.getLevel();
        if (level == null && logger.getParent() != null) {
            level = logger.getParent().getLevel();
        }
        return level;
    }
}
