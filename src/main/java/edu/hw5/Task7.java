package edu.hw5;

import java.util.regex.Pattern;

public final class Task7 {
    /** Содержит не менее 3 символов, причем третий символ равен 0. */
    private static final String THREE_ZERO_PATTERN = "[01]{2}0[01]*";

    /** Начинается и заканчивается одним и тем же символом. */
    private static final String SYMMETRIC_PATTERN = "^(0|1).*(\\1)$";

    /** Длина не менее 1 и не более 3. */
    private static final String SHORT_PATTERN = "^[01]{1,3}$";

    private Task7() {
    }

    public static boolean matchesThreeZeroPattern(final String inputString) {
        return Pattern.matches(THREE_ZERO_PATTERN, inputString);
    }

    public static boolean matchesSymmetricPattern(final String inputString) {
        return Pattern.matches(SYMMETRIC_PATTERN, inputString);
    }

    public static boolean matchesShortPattern(final String inputString) {
        return Pattern.matches(SHORT_PATTERN, inputString);
    }
}
