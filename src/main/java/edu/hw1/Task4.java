package edu.hw1;

public final class Task4 {

    private Task4() {
    }

    public static String fixString(final String brokenString) {
        StringBuilder fixedString = new StringBuilder();

        for (var i = 0; i < brokenString.length() - 1; i += 2) {
            fixedString.append(brokenString.charAt(i + 1));
            fixedString.append(brokenString.charAt(i));
        }

        if (fixedString.length() != brokenString.length()) {
            fixedString.append(brokenString.charAt(brokenString.length() - 1));
        }

        return fixedString.toString();
    }
}
