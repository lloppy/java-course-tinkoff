package edu.log;

import edu.log.analyzer.LogAnalyzer;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {

    @Test
    void analyzeLogs() {
        LocalDate localDate = parseDateString("17/May/2015");

        OffsetDateTime from = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        OffsetDateTime to = OffsetDateTime.now();

        Path path = Paths.get("src/main/java/edu/log/repository/logs.txt").toAbsolutePath();

        LogAnalyzer logAnalyzer = new LogAnalyzer(path, from, to);
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

    private LocalDate parseDateString(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
    }

}
