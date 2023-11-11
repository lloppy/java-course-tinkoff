package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MixParser extends Parser {
    private static final String PATTERN =
        "^(\\d+)\s+(days|day|weeks|week|months|month|years|year) ago$";

    public MixParser(final Parser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> getParseDate(final String string) {
        Optional<LocalDate> result = Optional.empty();

        try {
            Pattern pattern = Pattern.compile(PATTERN);
            Matcher matcher = pattern.matcher(string);

            if (matcher.matches()) {
                int amount = Integer.parseInt(matcher.group(1));
                String unit = matcher.group(2);

                switch (unit) {
                    case "day":
                    case "days":
                        result = Optional.of(LocalDate.now().minusDays(amount));
                        break;
                    case "week":
                    case "weeks":
                        result = Optional.of(LocalDate.now().minusWeeks(amount));
                        break;
                    case "month":
                    case "months":
                        result = Optional.of(LocalDate.now().minusMonths(amount));
                        break;
                    case "year":
                    case "years":
                        result = Optional.of(LocalDate.now().minusYears(amount));
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException | DateTimeParseException e) {
        }
        return result.isPresent() ? result : getNextParser().getParseDate(string);
    }

    private Parser getNextParser() {
        return nextParser;
    }
}
