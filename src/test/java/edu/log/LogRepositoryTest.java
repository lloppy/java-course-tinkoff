package edu.log;

import edu.log.repository.LogRepository;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class LogRepositoryTest {

    @Test
    void testReadLogsFirstFile() {
        // Given
        Path path = Paths.get("src/main/java/edu/log/repository/logs.txt").toAbsolutePath();
        LogRepository logRepository = new LogRepository(path);

        // When
        int size = logRepository.getLogList().size();

        // Then
        assertEquals(10_000, size);
    }

    @Test
    void testReadLogsSecondFile() {
        // Given
        Path path = Paths.get("src/main/java/edu/log/repository/logs2.txt").toAbsolutePath();
        LogRepository logRepository = new LogRepository(path);

        // When
        int size = logRepository.getLogList().size();

        // Then
        assertEquals(2300, size);
    }
}
