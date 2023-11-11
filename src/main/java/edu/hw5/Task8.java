package edu.hw5;

import java.util.regex.Pattern;

public final class Task8 {

    /** Нечетной длины */
    private static final String ODD_LENGTH_PATTERN = "^([01]{2})*[01]$";

    /** Начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину */
    private static final String ZERO_ODD_OR_ONE_EVEN_PATTERN = "^(0[01]{2})*$|^(1[01]{2})*[01]$";

    /** Количество 0 кратно 3 */
    private static final String MULTIPLE_OF_THREE_ZEROS_PATTERN = "^((1*01*){3})+$";

    /** Любая строка, кроме 11 или 111 */
    private static final String EXCEPT_11_OR_111_PATTERN = "^(?!1{2,3}$)[01]*$";

    /** Нет последовательных 1 */
    private static final String NO_CONSECUTIVE_ONES_PATTERN = "^(?!.*11)[01]*$";

    private Task8() {
    }

    public static boolean matchesOddLengthPattern(final String inputString) {
        return Pattern.matches(ODD_LENGTH_PATTERN, inputString);
    }

    public static boolean matchesZeroOddOrOneEvenPattern(final String inputString) {
        return Pattern.matches(ZERO_ODD_OR_ONE_EVEN_PATTERN, inputString);
    }

    public static boolean matchesMultipleOfThreeZerosPattern(final String inputString) {
        return Pattern.matches(MULTIPLE_OF_THREE_ZEROS_PATTERN, inputString);
    }

    public static boolean matchesExcept11Or111Pattern(final String inputString) {
        return Pattern.matches(EXCEPT_11_OR_111_PATTERN, inputString);
    }

    public static boolean matchesNoConsecutiveOnesPattern(final String inputString) {
        return Pattern.matches(NO_CONSECUTIVE_ONES_PATTERN, inputString);
    }
}


