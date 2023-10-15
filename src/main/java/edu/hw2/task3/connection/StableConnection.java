package edu.hw2.task3.connection;

import edu.hw2.task3.logger.StaticArray;

public final class StableConnection implements Connection {
    @Override
    public void execute(final String command) {
        StaticArray.add("execute StableConnection");
    }

    @Override
    public void close() {
        StaticArray.add("close with StableConnection");
    }
}
