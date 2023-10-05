package edu.hw1;

public class Task1 {
    public static int minutesToSeconds(String string_time) {
        String[] time = string_time.split(":");

        if (time.length != 2) {
            return -1;
        }

        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);

        if (seconds < 60) {
            return minutes * 60 + seconds;
        } else return -1;
    }
}
