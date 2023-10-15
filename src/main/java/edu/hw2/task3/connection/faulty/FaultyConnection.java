package edu.hw2.task3.connection.faulty;

import edu.hw2.task3.logger.StaticArray;
import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.exeptions.ConnectionException;

public final class FaultyConnection implements Connection {

    @Override
    public void execute(final String command) {
        StaticArray.add("Failed to execute command: " + command);
        throw new ConnectionException("Failed to execute command: " + command);
    }

    @Override
    public void close() {
        StaticArray.add("close with FaultyConnection");
    }
}
