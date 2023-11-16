package edu.log;

import edu.log.generators.entity.LogRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public final class LogRepository {
    private List<LogRecord> logList;

    public LogRepository() {
        logList = readLogs();
    }

    private List<LogRecord> readLogs() {
        Path currentDirectory = Paths.get("src/main/java/edu/log/").toAbsolutePath();
        Path filePath = currentDirectory.resolve("logs.txt");

        try {
            return Files.lines(filePath)
                .map(this::parseLogRecord)
                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
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
