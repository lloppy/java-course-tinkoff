package edu.hw3.task4;

enum Roman {
    THOUSAND(1000, "M"),
    NINE_HUNDRED(900, "CM"),
    FIVE_HUNDRED(500, "D"),
    FOUR_HUNDRED(400, "CD"),
    ONE_HUNDRED(100, "C"),
    NINETY(90, "XC"),
    FIFTY(50, "L"),
    FORTY(40, "XL"),
    TEN(10, "X"),
    NINE(9, "IX"),
    FIVE(5, "V"),
    FOUR(4, "IV"),
    ONE(1, "I");

    private final int romanValue;
    private final String romanNumeral;

    Roman(final int value, final String numeral) {
        this.romanValue = value;
        this.romanNumeral = numeral;
    }

    public final int getValue() {
        return romanValue;
    }

    public final String getNumeral() {
        return romanNumeral;
    }
}
