package edu.hw2;

import edu.hw2.task3.Task3.PopularCommandExecutor;
import edu.hw2.task3.connection.manager.DefaultConnectionManager;
import edu.hw2.task3.exeptions.ConnectionException;
import edu.hw2.task3.logger.StaticArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3Test {

    @Test
    void testThatExecuteCommandFaultyReturnsFailedToExecuteCommandMessage() {
        int attempts = 100;
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(1), attempts);

        String command = "cd";
        String faultyMessage = "Failed to execute command: " + command;

        try {
            executor.tryExecute(command);
        } catch (ConnectionException e) {
            String firstValue = StaticArray.getFirst();
            assertEquals(faultyMessage, firstValue);
        }
    }

    @Test
    void testThatExecuteCommandFaultyReturnsCloseWithFaultyConnectionMessage() {
        int attempts = 1;
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(1), attempts);

        String command = "command";
        String closeFaultyMessage = "close with FaultyConnection";

        try {
            executor.tryExecute(command);
        } catch (ConnectionException e) {
            String lastValue = StaticArray.getLast();
            assertEquals(closeFaultyMessage, lastValue);
        }
    }

    @Test
    void testThatExecuteCommandFaultyThrowsConnectionExceptionWithAttemptsMessage() {
        int attempts = 1;
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(1), attempts);

        String command = "cd";
        String faultyMessage = "Failed to execute command after " + attempts + " attempts";

        try {
            executor.tryExecute(command);
        } catch (ConnectionException e) {
            assertEquals(faultyMessage, e.getMessage());
        }
    }

    @Test
    void testThatFaultyCommandWithZeroAttemptsReturnedCloseFaultyMessage() {
        int attempts = 0;
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(1), attempts);

        String command = "cd";
        String closeFaultyMessage = "close with FaultyConnection";

        try {
            executor.tryExecute(command);
        } catch (ConnectionException e) {
            assertEquals(closeFaultyMessage, e.getMessage());
        }
    }

    @Test
    void testThatStableCommandWithZeroAttemptsReturnedCloseFaultyMessage() {
        int attempts = 0;
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(1), attempts);

        String command = "cd";
        String closeStableMessage = "close with StableConnection";

        try {
            executor.tryExecute(command);
        } catch (ConnectionException e) {
            assertEquals(closeStableMessage, e.getMessage());
        }
    }

    @Test
    void testThatExecuteCommandFaultyThrowsConnectionExceptionAfterManyAttempts() {
        int attempts = 100;
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(1), attempts);

        String command = "cd";
        String faultyMessage = "Failed to execute command after " + attempts + " attempts";

        try {
            executor.tryExecute(command);
        } catch (ConnectionException e) {
            assertEquals(faultyMessage, e.getMessage());
        }
    }

    @Test
    void testThatExecuteCommandSuccessfullyReturnsCloseWithStableConnectionMessage() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(0), 1);

        String command = "ls";
        String closeStableMessage = "close with StableConnection";

        executor.tryExecute(command);
        String lastValue = StaticArray.getLast();

        assertEquals(closeStableMessage, lastValue);
    }

    @Test
    void testThatUpdatePackagesCloseWithStableMessage() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(0), 1);

        executor.updatePackages();
        String closeStableMessage = "close with StableConnection";

        assertEquals(closeStableMessage, StaticArray.getLast());
    }
}
