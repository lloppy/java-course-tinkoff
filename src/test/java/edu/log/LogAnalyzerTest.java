package edu.log;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {

    @Test
    void analyzeLogs() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
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
