package edu.log;

import edu.log.generators.ReportGenerator;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void testThatMainGenerateAdocFormat() {
        // given
        String command = "java -jar nginx-log-stats.jar --format adoc --path ";
        Main.main(new String[] {command});

        //when
        ReportGenerator generator = CommandProcessor.processCommand(command);
        generator.generateReport("new_report_adoc");

        //then
        Path path = Path.of("src/main/java/edu/log/generators/reports").toAbsolutePath();
        Path generatedFile = path.resolve("new_report_adoc.adoc");
        assertTrue(Files.exists(generatedFile));
    }

    @Test
    void testThatMainGenerateMarkdownFormat() {
        // given
        String command = "java -jar nginx-log-stats.jar --format md --path ";
        Main.main(new String[] {command});

        //when
        ReportGenerator generator = CommandProcessor.processCommand(command);
        generator.generateReport("new_report_md");

        //then
        Path path = Path.of("src/main/java/edu/log/generators/reports").toAbsolutePath();
        Path generatedFile = path.resolve("new_report_md.md");
        assertTrue(Files.exists(generatedFile));
    }
}
