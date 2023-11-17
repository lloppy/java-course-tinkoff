package edu.log.analyzer;

import edu.log.entity.LogRecord;
import edu.log.repository.LogRepository;

import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LogAnalyzer {
    OffsetDateTime from;
    OffsetDateTime to;

    private List<LogRecord> logRecords;

    public LogAnalyzer(Path path, OffsetDateTime from, OffsetDateTime to) {
        LogRepository logRepository = new LogRepository(path);
        this.logRecords = logRepository.getLogList();
        this.from = from;
        this.to = to;
        analyzeLogs();
    }

    private Map<String, Integer> resourceCount = new HashMap<>();
    private Map<Integer, Integer> responseCodeCount = new HashMap<>();
    private long totalRequests = 0;
    private long totalResponseSize = 0;

    private void analyzeLogs() {
        for (LogRecord logRecord : logRecords) {
            if (logRecord.getTimeLocal().isAfter(from) && logRecord.getTimeLocal().isBefore(to)) {
                totalRequests++;

                String resource = logRecord.getSource();
                resourceCount.put(resource, resourceCount.getOrDefault(resource, 0) + 1);

                int responseCode = logRecord.getStatus();
                responseCodeCount.put(responseCode, responseCodeCount.getOrDefault(responseCode, 0) + 1);

                totalResponseSize += logRecord.getBodyBytesSent();
            }
        }
    }


    public long getTotalRequests() {
        return totalRequests;
    }

    public Map<String, Integer> getResourceCount() {
        return resourceCount;
    }

    public double getAverageResponseSize() {
        return totalResponseSize / (double) totalRequests;
    }

    public Map<Integer, Integer> getResponseCodeCount() {
        return responseCodeCount;
    }
}
