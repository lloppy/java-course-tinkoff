package edu.log;

import edu.log.entity.LogRecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogRecordTest {

    @Test
    void test() {
        String log =
            "144.76.117.56 - - [17/May/2015:13:05:03 +0000] \"GET /downloads/product_1 HTTP/1.1\" 404 341 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.22)\"";

        LogRecord logRecord = new LogRecord(log);

        assertEquals("144.76.117.56", logRecord.getRemoteAddress());
        assertEquals("-", logRecord.getRemoteUser());
        assertEquals("GET", logRecord.getRequest());
        assertEquals("/downloads/product_1 HTTP/1.1", logRecord.getSource());
        assertEquals(404, logRecord.getStatus());
        assertEquals(341, logRecord.getBodyBytesSent());
        assertEquals("-", logRecord.getHttpReferer());
        assertEquals("Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.22)", logRecord.getHttpUserAgent());

    }

    @Test
    void testData() {
        String log =
            "144.76.117.56 - - [17/May/2015:13:05:03 +0000] \"GET /downloads/product_1 HTTP/1.1\" 404 341 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.22)\"";
        LogRecord logRecord = new LogRecord(log);

        assertEquals(2015, logRecord.getTimeLocal().getYear());
        assertEquals(13, logRecord.getTimeLocal().getHour());
        assertEquals("MAY", logRecord.getTimeLocal().getMonth().toString());
    }
}