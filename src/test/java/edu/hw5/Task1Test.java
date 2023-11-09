package edu.hw5;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @Test
    void testThatGetDurationReturnedExpectedResultForTwoDates() {
        String firstData = "2022-03-12, 20:20 - 2022-03-12, 23:50";
        String secondData = "2022-04-01, 21:30 - 2022-04-02, 01:20";

        List<String> stringTimeData = new ArrayList<>();
        stringTimeData.add(firstData);
        stringTimeData.add(secondData);

        Task1 task1 = new Task1();
        String averageDuration = task1.getDuration(stringTimeData);

        assertEquals("3ч 40м", averageDuration);
    }

    @Test
    void testThatGetDurationReturnedExpectedResultForThreeDates() {
        String firstData = "2022-03-12, 20:20 - 2022-03-12, 23:50"; // 3h 30m
        String secondData = "2022-04-01, 21:30 - 2022-04-02, 01:20"; // 3h 50m
        String thirdData = "2022-04-01, 21:30 - 2022-04-02, 00:00"; // 2h 30m  -> 9h 50m -> 3h 16m

        List<String> stringTimeData = new ArrayList<>();
        stringTimeData.add(firstData);
        stringTimeData.add(secondData);
        stringTimeData.add(thirdData);

        Task1 task1 = new Task1();
        String averageDuration = task1.getDuration(stringTimeData);

        assertEquals("3ч 16м", averageDuration);
    }

    @Test
    public void testThatGetDurationReturnedExpectedResultForTwo24hDates() {
        List<String> timeData = new ArrayList<>();
        timeData.add("2022-03-12, 20:20 - 2022-03-13, 03:50"); // 3h 40m + 3h 50m = 7h 30m
        timeData.add("2022-04-01, 21:30 - 2022-04-02, 01:20"); // 2h 30m + 1h 20m = 3h 50m  -> 11h 20m -> 5h 40m

        Task1 task1 = new Task1();
        String averageDuration = task1.getDuration(timeData);

        assertEquals("5ч 40м", averageDuration);
    }

    @Test
    void testThatGetDurationReturnedExpectedResultForOneDate() {
        String firstData = "2022-03-12, 20:20 - 2022-03-12, 23:50"; // 3h 30m

        List<String> stringTimeData = new ArrayList<>();
        stringTimeData.add(firstData);

        Task1 task1 = new Task1();
        String averageDuration = task1.getDuration(stringTimeData);

        assertEquals("3ч 30м", averageDuration);
    }
}
