package edu.log.generators.entity;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRecord {
    private static final Pattern LOG_PATTERN = Pattern.compile(
        "^(.*) - (.*) \\[(.*)] \"(\\w+) (.*)\" (\\d{3}) (\\d+) \"(.+)\" \"(.*)\"");
    private static final DateTimeFormatter DATA_FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

    private String remoteAddress;
    private String remoteUser;
    private OffsetDateTime timeLocal;
    private String request;
    private int status;
    private int bodyBytesSent;
    private String httpReferer;
    private String httpUserAgent;
    private String codeResponse;
    private String source;

    public LogRecord(String logLine) {
        Matcher matcher = LOG_PATTERN.matcher(logLine);
        if (matcher.matches()) {
            remoteAddress = matcher.group(1);
            remoteUser = matcher.group(2);
            timeLocal = OffsetDateTime.parse(matcher.group(3), DATA_FORMATTER);
            request = matcher.group(4);
            source = matcher.group(5);
            status = Integer.parseInt(matcher.group(6));
            codeResponse = CodeResponse.getDescriptionByCode(status);
            httpReferer = matcher.group(8);
            httpUserAgent = matcher.group(9);

            try {
                bodyBytesSent = Integer.parseInt(matcher.group(7));
            } catch (NumberFormatException e) {
                bodyBytesSent = 0;
            }
        } else {
            throw new IllegalArgumentException("Invalid log format: " + logLine);
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

    public String getCodeResponse() {
        return codeResponse;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return String.format(
            "%s - %s [%s] \"%s\" %d %d \"%s\" \"%s\"",
            remoteAddress, remoteUser, timeLocal, request, status, bodyBytesSent, httpReferer, httpUserAgent
        );
    }
}
