package edu.log;

import edu.log.analyzer.LogAnalyzer;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {

    @Test
    void analyzeLogs() {
        Path path = Paths.get("src/main/java/edu/log/repository/logs.txt").toAbsolutePath();

        LogAnalyzer logAnalyzer = new LogAnalyzer(path, null, null);
        assertEquals(10_000, logAnalyzer.getTotalRequests());
    }

    @Test
    void getTotalRequests() {
    }

    @Test
    void getResourceCount() {
    }

    @Test
    void getAverageResponseSize() {
    }
}
