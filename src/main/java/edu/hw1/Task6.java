package edu.hw1;

import java.util.Arrays;

public class Task6 {

    public static int realization(final int n) {
        return isValid(n) ? countSteps(n) : -1;
    }

    private static int countSteps(int n) {
        int steps = 0;
        while (n != 6174) {
            n = kaprekar(n);
            steps++;
        }
        return steps;
    }

    private static int kaprekar(final int n) {
        String stringNumber = Integer.toString(n);

        char[] sortedArray = stringNumber.toCharArray();
        Arrays.sort(sortedArray);

        String ascending = new String(sortedArray);
        String descending = new StringBuilder(ascending).reverse().toString();

        int difference = Integer.parseInt(descending) - Integer.parseInt(ascending);

        return difference;
    }

    private static boolean isValid(final int n) {
        if (n >= 1000 && n <= 9999) {
            String stringNumber = Integer.toString(n);
            return !isSameCharacters(stringNumber); // Изменено на отрицание
        } else {
            return false;
        }
    }

    private static boolean isSameCharacters(final String stringNumber) {
        char firstChar = stringNumber.charAt(0);

        for (var i = 1; i < stringNumber.length(); i++) {
            if (stringNumber.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}
