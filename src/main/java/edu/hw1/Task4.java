package edu.hw1;

public class Task4 {

    public static String fixString(final String brokenString) {
        String fixedString = "";

        for (var i = 0; i < brokenString.length() - 1; i += 2) {
            fixedString += brokenString.charAt(i + 1);
            fixedString += brokenString.charAt(i);
        }

        if (fixedString.length() != brokenString.length()) {
            fixedString += brokenString.charAt(brokenString.length() - 1);
        }

        return fixedString;
    }
}
