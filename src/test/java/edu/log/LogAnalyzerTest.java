package edu.log;

import edu.log.analyzer.LogAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {
    private LocalDate localDate;
    private OffsetDateTime from;
    private OffsetDateTime to;
    private Path path;
    private LogAnalyzer logAnalyzer;

    @BeforeEach
    void setUp() {
        // given
        localDate = parseDateString("17/May/2015");
        from = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        to = OffsetDateTime.now();
        path = Paths.get("src/main/java/edu/log/repository/logs.txt").toAbsolutePath();

        // when
        logAnalyzer = new LogAnalyzer(path, from, to);
    }

    @Test
    void getTotalRequests() {
        // then
        assertEquals(10_000, logAnalyzer.getTotalRequests());
    }

    @Test
    void getResourceCount() {
        // then
        assertEquals(5559, logAnalyzer.getResourceCount().get("/downloads/product_1 HTTP/1.1"));
        assertEquals(4428, logAnalyzer.getResourceCount().get("/downloads/product_2 HTTP/1.1"));
        assertEquals(13, logAnalyzer.getResourceCount().get("/downloads/product_3 HTTP/1.1"));

        assertTrue(logAnalyzer.getResourceCount().get("/downloads/product_1 HTTP/1.1")
            + logAnalyzer.getResourceCount().get("/downloads/product_2 HTTP/1.1")
            + logAnalyzer.getResourceCount().get("/downloads/product_3 HTTP/1.1") == logAnalyzer.getTotalRequests());

    }

    @Test
    void getAverageResponseSize() {
        // then
        assertFalse(logAnalyzer.getAverageResponseSize() == 0);
        assertEquals(644_923, logAnalyzer.getAverageResponseSize());
    }

    private LocalDate parseDateString(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
    }
}
