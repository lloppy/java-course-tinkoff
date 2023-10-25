package edu.hw2.task3.connection.faulty;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.exeptions.ConnectionException;
import edu.hw2.task3.logger.StaticArray;

public final class FaultyConnection implements Connection {

    @Override
    public void execute(final String command) {
        String errorMessage = "Failed to execute command: " + command;
        StaticArray.add(errorMessage);
        throw new ConnectionException(errorMessage);
    }

    @Override
    public void close() {
        StaticArray.add("close with FaultyConnection");
    }
}
