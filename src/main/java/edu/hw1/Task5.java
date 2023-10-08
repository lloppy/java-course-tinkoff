package edu.hw1;

public class Task5 {

    public static Boolean isPalindromeDescendant(final Integer number) {
        var stringNumber = number.toString();

        if (isPalindrome(stringNumber)) {
            return true;
        } else if (stringNumber.length() % 2 == 0) {
            while (stringNumber.length() > 2) {
                stringNumber = sumPair(stringNumber);
                if (isPalindrome(stringNumber)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPalindrome(final String stringNum) {
        int length = stringNum.length();
        for (var i = 0; i < length / 2; i++) {
            if (stringNum.charAt(i) != stringNum.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String sumPair(final String stringNum) {
        StringBuilder sum = new StringBuilder();
        for (var i = 0; i < stringNum.length() - 1; i += 2) {
            int next = Integer.parseInt(String.valueOf(stringNum.charAt(i + 1)));
            int curr = Integer.parseInt(String.valueOf(stringNum.charAt(i)));
            sum.append(curr + next);
        }
        return sum.toString();
    }
}
