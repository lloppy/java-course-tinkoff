package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    public Task1() {
    }

    public String getDuration(List<String> stringTimeData) {
        List<String> timeData = stringTimeData;
        Duration[] durations = new Duration[stringTimeData.size()];

        long sum = 0;
        for (int i = 0; i < stringTimeData.size(); i++) {
            durations[i] = getSessionDuration(timeData.get(i));
            sum += durations[i].toMinutes();
        }

        long averageDuration = sum / durations.length;
        return String.format("%sч %sм", averageDuration / 60, (int) (averageDuration % 60));
    }

    public static Duration getSessionDuration(String sessionString) {
        LocalDateTime startDateTime = LocalDateTime.parse(sessionString.split(" - ")[0], FORMATTER);
        LocalDateTime endDateTime = LocalDateTime.parse(sessionString.split(" - ")[1], FORMATTER);

        return Duration.between(startDateTime, endDateTime);
    }

}

