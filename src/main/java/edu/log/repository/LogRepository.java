package edu.log.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.log.entity.LogRecord;

public final class LogRepository {
    private final static Logger LOGGER = LogManager.getLogger();

    private List<LogRecord> logList;
    private Path path;

    public LogRepository(final Path path) {
        this.path = path;
        logList = readLogs();
    }

    private List<LogRecord> readLogs() {
        try {
            List<String> lines = Files.readAllLines(path);
            return lines.stream()
                .map(this::parseLogRecord)
                .collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Error reading file logs", e);
            return List.of();
        }
    }


    private LogRecord parseLogRecord(final String logLine) {
        return new LogRecord(logLine);
    }

    public List<LogRecord> getLogList() {
        return logList;
    }
}
