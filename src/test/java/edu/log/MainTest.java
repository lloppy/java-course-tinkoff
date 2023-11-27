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
        String command = "java -jar nginx-log-stats.jar --path src/main/java/edu/log/repository/logs2.txt --from 18/May/2015 --format adoc";
        Main.main(new String[] {command});

        //when
        ReportGenerator generator = CommandProcessor.processCommand(command);
        generator.generateReport("report_adoc_in_path_resources");

        //then
        Path path = Path.of("src/main/resources/reports").toAbsolutePath();
        Path generatedFile = path.resolve("report_adoc_in_path_resources.adoc");
        assertTrue(Files.exists(generatedFile));
    }

    @Test
    void testThatMainGenerateMarkdownFormat() {
        // given
        String command = "java -jar nginx-log-stats.jar --path src/main/java/edu/log/repository/logs2.txt --from 18/May/2015 --format markdow";
        Main.main(new String[] {command});

        //when
        ReportGenerator generator = CommandProcessor.processCommand(command);
        generator.generateReport("report_md_in_path_resources");

        //then
        Path path = Path.of("src/main/resources/reports").toAbsolutePath();
        Path generatedFile = path.resolve("report_md_in_path_resources.md");
        assertTrue(Files.exists(generatedFile));
    }
}
