package edu.hw2.task3;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.manager.ConnectionManager;
import edu.hw2.task3.exeptions.ConnectionException;

public final class Task3 {
    private Task3() {
    }

    private static void closeConnection(final Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final class PopularCommandExecutor {

        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(
            final ConnectionManager connectionManager,
            final int maxAttemptsCount
        ) {
            this.manager = connectionManager;
            this.maxAttempts = maxAttemptsCount;
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        public void tryExecute(final String command) {
            Connection connection = manager.getConnection();

            for (int attempts = 0; attempts < maxAttempts; attempts++) {
                try {
                    connection.execute(command);
                    closeConnection(connection);
                    return;
                } catch (ConnectionException cause) {
                    if (attempts == maxAttempts - 1) {
                        closeConnection(connection);
                        throw new ConnectionException(
                            "Failed to execute command after "
                                + maxAttempts + " attempts",
                            cause
                        );
                    }
                }
            }
        }
    }
}

