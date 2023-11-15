package edu.log;

import java.time.OffsetDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRecord {
    private static final Pattern LOG_PATTERN = Pattern.compile(
        "^(([0-9]{1,3}\\.){3}[0-9]{1,3}) - (.*) \\[(.*) (.*)\\] \"(.*)\" (\\d{3}) (\\d+) \"(.+)\" \"(.*)\" \"(.*)\"$"
    );

    private String remoteAddress;
    private String remoteUser;
    private OffsetDateTime timeLocal;
    private String request;
    private int status;
    private int bodyBytesSent;
    private String httpReferer;
    private String httpUserAgent;

    public LogRecord(String logLine) {
        Matcher matcher = LOG_PATTERN.matcher(logLine);
        if (matcher.matches()) {
            remoteAddress = matcher.group(1);
            remoteUser = matcher.group(3);
            timeLocal = OffsetDateTime.parse(matcher.group(4));
            request = matcher.group(6);
            status = Integer.parseInt(matcher.group(7));
            bodyBytesSent = Integer.parseInt(matcher.group(8));
            httpReferer = matcher.group(9);
            httpUserAgent = matcher.group(10);
        } else {
            throw new IllegalArgumentException("Invalid log format: " + logLine);
        }
    }

    // Геттеры для получения значений полей

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

    @Override
    public String toString() {
        return String.format(
            "%s - %s [%s] \"%s\" %d %d \"%s\" \"%s\"",
            remoteAddress, remoteUser, timeLocal, request, status, bodyBytesSent, httpReferer, httpUserAgent
        );
    }
}
