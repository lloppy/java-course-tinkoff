package edu.hw1;

public class Task2 {
    public static int countDigits(int number) {
        int counter = 0;

        do {
            number /= 10;
            counter++;
        } while (Math.abs(number) > 0);

        return counter;
    }
}
