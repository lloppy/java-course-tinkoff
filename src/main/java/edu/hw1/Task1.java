package edu.hw1;

public class Task1 {
    private static final int SECONDS_PER_MINUTE = 60;

    public static int minutesToSeconds(final String stringTime) {
        String[] time = stringTime.split(":");

        if (time.length != 2) {
            return -1;
        }

        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);

        if (seconds < SECONDS_PER_MINUTE) {
            return minutes * SECONDS_PER_MINUTE + seconds;
        } else {
            return -1;
        }
    }
}
