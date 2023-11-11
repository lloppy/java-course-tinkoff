package edu.hw5;

public final class Task5 {
    private static final String PATTERN_LICENSE_PLATE = "[А-Я]\\d{3}[А-Я]{2}\\d{3}";

    private Task5() {
    }

    public static boolean validateLicensePlates(final String password) {
        return password.matches(PATTERN_LICENSE_PLATE);
    }
}
