package edu.hw7.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Task1 {
    private static final Logger LOGGER = Logger.getLogger(Task1.class.getName());

    private Task1() {
    }

    public static Integer getThreadsResult(final Integer limit) {
        Action action = new Action(limit);

        Thread incrementer = action.getNewThread("First");
        Thread incrementer2 = action.getNewThread("Second");
        Thread incrementer3 = action.getNewThread("Third");

        incrementer.start();
        incrementer2.start();
        incrementer3.start();

        try {
            incrementer.join();
            incrementer2.join();
            incrementer3.join();

        } catch (InterruptedException e) {
            LOGGER.severe(String.format("Thread interrupted: %s", e.getMessage()));
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }

        return action.getValue();
    }
}
