package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Task1 {
    private Task1() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task1.class.getName());

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
            e.printStackTrace();
            LOGGER.severe("Thread interrupted: " + e.getMessage());
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return action.getValue();
    }

    private static final class Action {
        private AtomicInteger value = new AtomicInteger(0);
        private int limit;

        Action(final int limitValueForOneThread) {
            this.limit = limitValueForOneThread;
        }

        public Thread getNewThread(final String nameThread) {
            var incrementer = new Thread(() -> {
                for (int i = 0; i < this.limit; i++) {
                    increment();
                    LOGGER.info(nameThread + " thread increased counter to " + value);
                }
            });
            return incrementer;
        }

        private void increment() {
            value.incrementAndGet();
        }

        public int getValue() {
            return value.get();
        }
    }
}
