package edu.hw1;

import java.util.Arrays;

public class Task6 {

    public static int realization(int n) {
        return isValid(n) ? countSteps(n) : -1;
    }

    private static int countSteps(int n) {
        var steps = 0;
        while (n != 6174) {
            n = kaprekar(n);
            steps++;
        }
        return steps;
    }

    private static int kaprekar(int n) {
        String stringNumber = Integer.toString(n);

        char[] sortedArray = stringNumber.toCharArray();
        Arrays.sort(sortedArray);

        String ascending = new String(sortedArray);
        String descending = new StringBuilder(new String(sortedArray)).reverse().toString();

        int difference = Integer.parseInt(descending) - Integer.parseInt(ascending);

        return difference;
    }

    private static boolean isValid(int n) {
        if (n >= 1000 && n <= 9999) {
            String stringNumber = Integer.toString(n);
            return !isSameCharacters(stringNumber); // Изменено на отрицание
        } else {
            return false;
        }
    }

    private static boolean isSameCharacters(String stringNumber) {
        char firstChar = stringNumber.charAt(0);

        for (var i = 1; i < stringNumber.length(); i++) {
            if (stringNumber.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}
