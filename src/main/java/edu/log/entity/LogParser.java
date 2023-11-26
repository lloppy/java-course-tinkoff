package edu.log.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogParser {
    private static final Logger LOGGER = Logger.getLogger(LogParser.class.getName());
    private static final String ERROR_MESSAGE = "Error %s has occurred in %s. Error value is %s";
    private static final String DEFAULT_DATE_STRING = "17/May/2015";

    private static final DateTimeFormatter DATA_FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

    public static String parseRemoteAddress(final String remoteAddress) {
        return parseString(remoteAddress, "parseRemoteAddress");
    }

    public static String parseRemoteUser(final String remoteUser) {
        return parseString(remoteUser, "parseRemoteUser");
    }

    public static OffsetDateTime parseTimeLocal(final String timeLocal) {
        try {
            return OffsetDateTime.parse(timeLocal, DATA_FORMATTER);
        } catch (Exception e) {
            printLog(timeLocal, "parseTimeLocal", e);
            LocalDate localDate = LocalDate.parse(
                DEFAULT_DATE_STRING,
                DateTimeFormatter.ofPattern("dd/MMM/yyyy")
            );

            return localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        }
    }

    public static String parseRequest(final String request) {
        return parseString(request, "parseRequest");
    }

    public static String parseSource(final String source) {
        return parseString(source, "parseSource");
    }

    public static int parseStatus(final String status) {
        try {
            return Integer.parseInt(status);
        } catch (NumberFormatException e) {
            printLog(status, "parseStatus", e);
            return 0;
        }
    }

    public static String parseHttpReferer(final String httpReferer) {
        return parseString(httpReferer, "parseHttpReferer");
    }

    public static String parseHttpUserAgent(final String httpUserAgent) {
        return parseString(httpUserAgent, "parseHttpUserAgent");
    }

    public static int parseBodyBytesSent(final String bodyBytesSent) {
        try {
            return Integer.parseInt(bodyBytesSent);
        } catch (NumberFormatException e) {
            printLog(bodyBytesSent, "parseBodyBytesSent", e);
            return 0;
        }
    }

    private static void printLog(String stringValue, String methodName, Exception e) {
        LOGGER.log(
            Level.WARNING,
            String.format(ERROR_MESSAGE, e, methodName, stringValue)
        );
    }

    private static String parseString(String stringValue, String methodName) {
        try {
            if (stringValue != null) {
                return stringValue;
            } else {
                return "";
            }
        } catch (NumberFormatException e) {
            printLog(stringValue, methodName, e);
            return "";
        }
    }
}
