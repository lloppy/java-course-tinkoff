package edu.hw5;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public final class Task2 {
    private Task2() {
    }

    public static List<LocalDate> findFridays(final int year) {
        return LocalDate.of(year, 1, 1)
            .datesUntil(LocalDate.of(year + 1, 1, 1))
            .filter(date -> date.getDayOfWeek() == java.time.DayOfWeek.FRIDAY && date.getDayOfMonth() == 13)
            .collect(Collectors.toList());
    }
}
