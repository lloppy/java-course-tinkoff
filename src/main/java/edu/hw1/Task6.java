package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private static final int CONSTANT_KAPREKAR = 6174;
    private static final int START_FOUR_DIGIT_NUMBER = 1000;
    private static final int END_FOUR_DIGIT_NUMBER = 9999;

    private Task6() {
    }

    public static int realization(final int n) {
        return isValid(n) ? countSteps(n) : -1;
    }

    private static int countSteps(final int n) {
        int currNumber = n;
        int steps = 0;
        while (currNumber != CONSTANT_KAPREKAR) {
            currNumber = kaprekar(currNumber);
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

        return Integer.parseInt(descending) - Integer.parseInt(ascending);
    }

    private static boolean isValid(final int n) {
        if (n >= START_FOUR_DIGIT_NUMBER && n <= END_FOUR_DIGIT_NUMBER) {
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
