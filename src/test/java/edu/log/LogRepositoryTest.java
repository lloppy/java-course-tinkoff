package edu.log;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogRepositoryTest {

    @Test
    void readLogs() {
        LogRepository logRepository = new LogRepository();
        int size = logRepository.getLogList().size();

        assertEquals(10_000, size);

    }
}
