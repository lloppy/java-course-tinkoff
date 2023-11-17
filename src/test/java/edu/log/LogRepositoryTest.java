package edu.log;

import edu.log.repository.LogRepository;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class LogRepositoryTest {

    @Test
    void readLogs() {
        Path path = Paths.get("src/main/java/edu/log/repository/logs.txt").toAbsolutePath();
        LogRepository logRepository = new LogRepository(path);
        int size = logRepository.getLogList().size();

        assertEquals(10_000, size);

    }
}
