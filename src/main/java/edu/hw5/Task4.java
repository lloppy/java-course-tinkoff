package edu.hw5;

public final class Task4 {
    private static final String PATTERN = ".*[~!@#$%^&*|].*";

    private Task4() {
    }

    public static boolean checkPassword(final String password) {
        return password.matches(PATTERN);
    }

}
