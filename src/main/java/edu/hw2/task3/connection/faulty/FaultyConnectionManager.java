package edu.hw2.task3.connection.faulty;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.manager.ConnectionManager;

public final class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
