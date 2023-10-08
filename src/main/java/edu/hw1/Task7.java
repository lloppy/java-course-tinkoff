package edu.hw1;

public class Task7 {

    public static int rotateLeft(final int n, final int shift) {
        String binary = Integer.toBinaryString(n);
        StringBuilder shiftedString = new StringBuilder(binary);

        for (var i = 0; i < shift; i++) {
            char start = shiftedString.charAt(0);
            shiftedString.deleteCharAt(0);
            shiftedString.append(start);
        }

        return Integer.parseInt(shiftedString.toString(), 2);
    }

    public static int rotateRight(final int n, final int shift) {
        String binary = Integer.toBinaryString(n);
        StringBuilder shiftedString = new StringBuilder(binary);

        for (var i = 0; i < shift; i++) {
            char end = shiftedString.charAt(shiftedString.length() - 1);
            shiftedString.deleteCharAt(shiftedString.length() - 1);
            shiftedString.insert(0, end);
        }

        return Integer.parseInt(shiftedString.toString(), 2);
    }
}
