package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task0 {
    private Task0() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(final String[] args) {
        // Метод выводит в лог - Привет, мир!.
        LOGGER.info("Привет, мир!");
    }

}
