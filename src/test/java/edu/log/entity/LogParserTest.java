package edu.log.entity;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogParserTest {
    private static final DateTimeFormatter DATA_FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

    @Test
    void testParseRemoteAddress() {
        String remoteAddress = "93.180.71.3";
        assertEquals(remoteAddress, LogParser.parseRemoteAddress(remoteAddress));

        assertEquals("", LogParser.parseRemoteAddress(null));
    }

    @Test
    void testParseRemoteUser() {
        String remoteUser = "-";
        assertEquals(remoteUser, LogParser.parseRemoteUser(remoteUser));

        assertEquals("", LogParser.parseRemoteUser(null));
    }

    @Test
    void testParseTimeLocal() {
        String timeLocal = "17/May/2015:00:00:00 +0000";
        OffsetDateTime expected = OffsetDateTime.parse("17/May/2015:00:00:00 +0000", DATA_FORMATTER);
        assertEquals(expected, LogParser.parseTimeLocal(timeLocal));

        String invalidTimeLocal = "invalid_timestamp";
        OffsetDateTime defaultTime = LogParser.parseTimeLocal(invalidTimeLocal);
        assertEquals(expected, defaultTime);
    }

    @Test
    void testParseRequest() {
        String request = "GET /downloads/product_1 HTTP/1.1";
        assertEquals(request, LogParser.parseRequest(request));

        assertEquals("", LogParser.parseRequest(null));
    }

    @Test
    void testParseSource() {
        String source = "Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)";
        assertEquals(source, LogParser.parseSource(source));

        assertEquals("", LogParser.parseSource(""));
    }

    @Test
    void testParseStatus() {
        String status = "304";
        assertEquals(304, LogParser.parseStatus(status));

        String invalidStatus = "not_an_integer";
        assertEquals(0, LogParser.parseStatus(invalidStatus));
    }

    @Test
    void testParseHttpReferer() {
        String httpReferer = "-";
        assertEquals(httpReferer, LogParser.parseHttpReferer(httpReferer));

        assertEquals("", LogParser.parseHttpReferer(""));
    }

    @Test
    void testParseHttpUserAgent() {
        String httpUserAgent = "Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)";
        assertEquals(httpUserAgent, LogParser.parseHttpUserAgent(httpUserAgent));

        assertEquals("", LogParser.parseHttpUserAgent(null));
    }

    @Test
    void testParseBodyBytesSent() {
        String bodyBytesSent = "100";
        assertEquals(100, LogParser.parseBodyBytesSent(bodyBytesSent));

        String invalidBodyBytesSent = "not_an_integer";
        assertEquals(0, LogParser.parseBodyBytesSent(invalidBodyBytesSent));
    }
}
