package edu.log.generators;

import edu.log.analyzer.LogAnalyzer;
import java.nio.file.Path;
import java.nio.file.Paths;


public final class AsciiDocReportGenerator extends ReportGenerator {
    private final static String FILE_FORMAT = "====";

    private LogAnalyzer logAnalyzer;

    public AsciiDocReportGenerator() {
    }

    @Override
    public void generateReport(final String fileName) {
        logAnalyzer = new LogAnalyzer(path, from, to);

        Path currentDirectory = Paths.get("src/main/resources/reports").toAbsolutePath();
        Path filePath = currentDirectory.resolve(fileName + ".adoc");

        writeLog(filePath, FILE_FORMAT, logAnalyzer);
    }
}
