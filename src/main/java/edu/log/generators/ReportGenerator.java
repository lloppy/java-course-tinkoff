package edu.log.generators;

import edu.log.entity.FileFormat;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class ReportGenerator {
    protected Path path;
    protected OffsetDateTime from;
    protected OffsetDateTime to;
    protected FileFormat format;

    public ReportGenerator() {
        LocalDate localDate = LocalDate.parse("17/May/2015", DateTimeFormatter.ofPattern("dd/MMM/yyyy").withLocale(Locale.ENGLISH));

        this.path = Paths.get("src/main/java/edu/log/repository/logs.txt").toAbsolutePath();
        this.from = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        this.to = OffsetDateTime.now();
        this.format = FileFormat.MARKDOWN;
    }

    public void setPath(String path) {
        this.path = Paths.get(path).toAbsolutePath();
    }

    public void setFrom(String from) {
        if (from == null || from.isEmpty()) from = "17/May/2015";

        LocalDate localDate = LocalDate.parse(from, DateTimeFormatter.ofPattern("dd/MMM/yyyy").withLocale(Locale.ENGLISH));
        this.from = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    public void setTo(String to) {
        if (to == null || to.isEmpty()) to = "17/May/2023";

        LocalDate localDate = LocalDate.parse(to, DateTimeFormatter.ofPattern("dd/MMM/yyyy").withLocale(Locale.ENGLISH));
        this.to = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    public void setFormat(FileFormat format) {
        this.format = format;
    }

    public abstract void generateReport(String fileName);
}

