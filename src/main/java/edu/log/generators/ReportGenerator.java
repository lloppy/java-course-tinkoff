package edu.log.generators;

import edu.log.entity.FileFormat;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public abstract class ReportGenerator {
    protected Path path;
    protected OffsetDateTime from;
    protected OffsetDateTime to;
    protected FileFormat format;

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

    public void setPath(String path) {
        this.path = Paths.get(path).toAbsolutePath();
    }

    public void setFrom(String stringFrom) {
        String fromDate = getDefaultIfNullOrEmpty(stringFrom, DEFAULT_DATE_STRING);
        this.from = parseDateString(fromDate).atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    public void setTo(String stringTo) {
        String toDate = getDefaultIfNullOrEmpty(stringTo, "17/May/2023");
        this.to = parseDateString(toDate).atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    public void setFormat(FileFormat format) {
        this.format = format;
    }

    public abstract void generateReport(String fileName);

    private LocalDate parseDateString(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
    }

    private String getDefaultIfNullOrEmpty(String value, String defaultValue) {
        return (value == null || value.isEmpty()) ? defaultValue : value;
    }

    private Path getDefaultFilePath() {
        return Paths.get(DEFAULT_FILE_PATH);
    }
}
