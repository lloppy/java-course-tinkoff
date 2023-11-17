package edu.log;

import edu.log.entity.FileFormat;
import edu.log.generators.AsciiDocReportGenerator;
import edu.log.generators.ReportGenerator;
import org.junit.jupiter.api.Test;

class RunTest {

    @Test
    void main() {
        ReportGenerator generator = new AsciiDocReportGenerator();
        generator.setPath("src/main/java/edu/log/repository/logs.txt");
        generator.setFrom("18/May/2015"); // первые записи от 17го числа
        generator.setTo(null);
        generator.setFormat(FileFormat.MARKDOWN);
        generator.generateReport("reportAdoc");

        // записей стало меньше 10_000
    }
}
