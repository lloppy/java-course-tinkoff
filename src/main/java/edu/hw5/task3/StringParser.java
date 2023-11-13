package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public final class StringParser extends Parser {

    public StringParser(final Parser nextParser) {
        super(nextParser);
    }

    @Override public Optional<LocalDate> getParseDate(final String string) {
        if (string.equalsIgnoreCase("tomorrow")) {
            return Optional.of(LocalDate.now().plusDays(1));
        } else if (string.equalsIgnoreCase("today")) {
            return Optional.of(LocalDate.now());
        } else if (string.equalsIgnoreCase("yesterday")) {
            return Optional.of(LocalDate.now().minusDays(1));
        } else {
            return getNextParser().getParseDate(string);
        }
    }

    private Parser getNextParser() {
        return nextParser;
    }
}
