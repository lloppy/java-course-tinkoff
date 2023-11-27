package edu.log.entity;

import java.time.OffsetDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static edu.log.entity.LogParser.parseBodyBytesSent;
import static edu.log.entity.LogParser.parseHttpReferer;
import static edu.log.entity.LogParser.parseHttpUserAgent;
import static edu.log.entity.LogParser.parseRemoteAddress;
import static edu.log.entity.LogParser.parseRemoteUser;
import static edu.log.entity.LogParser.parseRequest;
import static edu.log.entity.LogParser.parseSource;
import static edu.log.entity.LogParser.parseStatus;
import static edu.log.entity.LogParser.parseTimeLocal;

public final class LogRecord {

    @SuppressWarnings("LineLength")
    private static final Pattern LOG_PATTERN = Pattern.compile(
        "^(.*) - (.*) \\[(.*)] \"(\\w+) (.*)\" (\\d{3}) (\\d+) \"(.+)\" \"(.*)\"");

    private final String remoteAddress;
    private final String remoteUser;
    private final OffsetDateTime timeLocal;
    private final String request;
    private final int status;
    private final String httpReferer;
    private final String httpUserAgent;
    private final String source;
    private int bodyBytesSent;

    @SuppressWarnings("MagicNumber")
    public LogRecord(final String logLine) {
        Matcher matcher = LOG_PATTERN.matcher(logLine);
        if (matcher.matches()) {
            remoteAddress = parseRemoteAddress(matcher.group(1));
            remoteUser = parseRemoteUser(matcher.group(2));
            timeLocal = parseTimeLocal(matcher.group(3));
            request = parseRequest(matcher.group(4));
            source = parseSource(matcher.group(5));
            status = parseStatus(matcher.group(6));
            bodyBytesSent = parseBodyBytesSent(matcher.group(7));
            httpReferer = parseHttpReferer(matcher.group(8));
            httpUserAgent = parseHttpUserAgent(matcher.group(9));
        } else {
            throw new IllegalArgumentException(
                String.format("Invalid log format: %s", logLine)
            );
        }
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public OffsetDateTime getTimeLocal() {
        return timeLocal;
    }

    public String getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    public int getBodyBytesSent() {
        return bodyBytesSent;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public String getHttpUserAgent() {
        return httpUserAgent;
    }

    public String getSource() {
        return source;
    }
}
