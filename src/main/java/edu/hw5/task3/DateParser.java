package edu.hw5.task3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class DateParser extends Parser {

    public DateParser(final Parser nextParser) {
        super(nextParser);
    }

    List<DateTimeFormatter> dataPatternsList = List.of(
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("dd-MM-yyyy"),
        DateTimeFormatter.ofPattern("MM-dd-yyyy"),
        DateTimeFormatter.ofPattern("d/M/yyyy"),
        DateTimeFormatter.ofPattern("d/M/yy")
    );

    @Override
    public Optional<LocalDate> getParseDate(final String string) {
        return dataPatternsList.stream()
            .map(formatter -> tryParseDate(string, formatter))
            .filter(Objects::nonNull)
            .findFirst()
            .map(LocalDate::from);
    }

    private LocalDate tryParseDate(final String string, final DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(string, formatter);
        } catch (DateTimeException ignored) {
            return null;
        }
    }
}
