package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static java.time.format.DateTimeFormatter.ofPattern;

public final class Task1 {
    private static final DateTimeFormatter FORMATTER =
        ofPattern("yyyy-MM-dd, HH:mm");
    private static final int TIME_DIVIDER = 60;

    private Task1() {
    }

    public static String getDuration(final List<String> stringTimeData) {
        List<String> timeData = stringTimeData;
        Duration[] durations = new Duration[stringTimeData.size()];

        long sum = 0;
        for (int i = 0; i < stringTimeData.size(); i++) {
            durations[i] = getSessionDuration(timeData.get(i));
            sum += durations[i].toMinutes();
        }

        long averageDuration = sum / durations.length;
        return String.format(
            "%sч %sм",
            averageDuration / TIME_DIVIDER,
            (int) (averageDuration % TIME_DIVIDER)
        );
    }

    private static Duration getSessionDuration(final String sessionString) {
        String[] session = sessionString.split(" - ");

        LocalDateTime startDate = LocalDateTime.parse(session[0], FORMATTER);
        LocalDateTime endDate = LocalDateTime.parse(session[1], FORMATTER);

        return Duration.between(startDate, endDate);
    }
}

