package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public final class Action {
    private static final Logger LOGGER = Logger.getLogger(Action.class.getName());
    private final AtomicInteger value = new AtomicInteger(0);
    private final int limit;

    public Action(final int limitValueForOneThread) {
        this.limit = limitValueForOneThread;
    }

    public Thread getNewThread(final String nameThread) {
        return new Thread(() -> {
            for (int i = 0; i < this.limit; i++) {
                increment();
                LOGGER.info(nameThread + " thread increased counter to " + value);
            }
        });
    }

    private void increment() {
        value.incrementAndGet();
    }

    public int getValue() {
        return value.get();
    }
}
