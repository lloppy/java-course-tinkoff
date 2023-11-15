package edu.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogAnalyzer {
    private Map<String, Integer> resourceCount = new HashMap<>();
    private Map<Integer, Integer> responseCodeCount = new HashMap<>();
    private long totalRequests = 0;
    private long totalResponseSize = 0;

    public void analyzeLogs(List<LogRecord> logRecords) {
        for (LogRecord logRecord : logRecords) {
            totalRequests++;

            String resource = logRecord.getRequest();
            resourceCount.put(resource, resourceCount.getOrDefault(resource, 0) + 1);

            int responseCode = logRecord.getStatus();
            responseCodeCount.put(responseCode, responseCodeCount.getOrDefault(responseCode, 0) + 1);

            totalResponseSize += logRecord.getBodyBytesSent();
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

}
