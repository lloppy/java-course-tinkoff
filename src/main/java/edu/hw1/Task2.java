package edu.hw1;

public final class Task2 {
    private static final int BASE = 10;

    private Task2() {
    }

    public static int countDigits(final int number) {
        int currNumber = number;
        int counter = 0;

        do {
            currNumber /= BASE;
            counter++;
        } while (Math.abs(currNumber) > 0);

        return counter;
    }
}
