package com.digitalnurture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLJ4LoggingExercise1 {
    private static final Logger logger = LoggerFactory.getLogger(SLJ4LoggingExercise1.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
