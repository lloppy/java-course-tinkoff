package edu.log.generators;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import edu.log.analyzer.LogAnalyzer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class MarkdownReportGenerator extends ReportGenerator {
    private final static Logger LOGGER = LogManager.getLogger();
    private LogAnalyzer logAnalyzer;

    public MarkdownReportGenerator() {
    }

    @Override
    public void generateReport(final String fileName) {
        logAnalyzer = new LogAnalyzer(path, from, to);
        String fileFormat = "####";

        Path currentDirectory = Paths.get("src/main/java/edu/log/generators/reports").toAbsolutePath();
        Path filePath = currentDirectory.resolve(fileName + ".md");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath.toFile()))) {
            ReportPrinter.writeGeneralInfoSection(fileFormat, logAnalyzer, writer, fileName, from, to);
            ReportPrinter.writeResourceSection(fileFormat, logAnalyzer, writer);
            ReportPrinter.writeResponseCodeSection(fileFormat, logAnalyzer, writer);
        } catch (IOException e) {
            LOGGER.error("Error writing the report to file");
        }
    }
}
