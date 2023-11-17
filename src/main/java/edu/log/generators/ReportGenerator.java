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

    public ReportGenerator() {
        // Set default values
        LocalDate localDate = LocalDate.parse(
                "17/May/2015",
                DateTimeFormatter.ofPattern("dd/MMM/yyyy")
        );

        this.path = Paths.get("src/main/java/edu/log/repository/logs.txt")
                .toAbsolutePath();
        this.from = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        this.to = OffsetDateTime.now();
        this.format = FileFormat.MARKDOWN;
    }

    public void setPath(String path) {
        this.path = Paths.get(path).toAbsolutePath();
    }

    public void setFrom(final String stringFrom) {
        String fromDate = stringFrom;
        if (fromDate == null || fromDate.isEmpty()) fromDate = "17/May/2015";

        LocalDate localDate = LocalDate.parse(
                fromDate,
                DateTimeFormatter.ofPattern("dd/MMM/yyyy")
        );
        this.from = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    public void setTo(final String stringTo) {
        String toDate = stringTo;
        if (toDate == null || toDate.isEmpty()) toDate = "17/May/2023";

        LocalDate localDate = LocalDate.parse(
                toDate,
                DateTimeFormatter.ofPattern("dd/MMM/yyyy")
        );
        this.to = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    public void setFormat(final FileFormat format) {
        this.format = format;
    }

    public abstract void generateReport(String fileName);
}

