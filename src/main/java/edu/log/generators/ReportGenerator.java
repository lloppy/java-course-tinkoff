package edu.log.generators;

import edu.log.analyzer.LogAnalyzer;
import edu.log.entity.FileFormat;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ReportGenerator {
    protected Path path;
    protected OffsetDateTime from;
    protected OffsetDateTime to;
    protected FileFormat format;
    private final static Logger LOGGER = LogManager.getLogger();
    private static final String DEFAULT_DATE_STRING = "17/May/2015";
    private static final String DEFAULT_FILE_PATH = "src/main/java/edu/log/repository/logs.txt";

    public ReportGenerator() {
        // Set default values
        LocalDate localDate = parseDateString(DEFAULT_DATE_STRING);

        this.path = getDefaultFilePath().toAbsolutePath();
        this.from = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        this.to = OffsetDateTime.now();
        this.format = FileFormat.MARKDOWN;
    }

    public void setPath(final String path) {
        this.path = Paths.get(path).toAbsolutePath();
    }

    public void setFrom(final String stringFrom) {
        String fromDate = getDefaultIfNullOrEmpty(stringFrom, DEFAULT_DATE_STRING);
        this.from = parseDateString(fromDate).atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    public void setTo(final String stringTo) {
        String toDate = getDefaultIfNullOrEmpty(stringTo, DEFAULT_DATE_STRING);
        this.to = parseDateString(toDate).atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    public void setFormat(final FileFormat format) {
        this.format = format;
    }

    public abstract void generateReport(String fileName);

    private LocalDate parseDateString(final String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
    }

    private String getDefaultIfNullOrEmpty(
        final String value,
        final String defaultValue
    ) {
        return (value == null || value.isEmpty()) ? defaultValue : value;
    }

    private Path getDefaultFilePath() {
        return Paths.get(DEFAULT_FILE_PATH);
    }

    protected void writeLog(
        final Path filePath,
        final String fileFormat,
        final LogAnalyzer logAnalyzer
    ) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath.toFile()))) {
            ReportPrinter.writeGeneralInfoSection(
                fileFormat,
                logAnalyzer,
                writer,
                filePath.getFileName().toString(),
                from,
                to
            );
            ReportPrinter.writeResourceSection(fileFormat, logAnalyzer, writer);
            ReportPrinter.writeResponseCodeSection(fileFormat, logAnalyzer, writer);
        } catch (IOException e) {
            LOGGER.error("Error writing the report to file: {}", e.toString(), e);
        }
    }
}
