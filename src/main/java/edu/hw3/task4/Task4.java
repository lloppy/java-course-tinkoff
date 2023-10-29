package edu.hw3.task4;

public final class Task4 {
    private Task4() {
    }

    public static String convertToRoman(final int numberToConvert) {
        int number = numberToConvert;
        StringBuilder result = new StringBuilder();

        for (Roman romanValue : Roman.values()) {
            while (number >= romanValue.getValue()) {
                result.append(romanValue.getNumeral());
                number -= romanValue.getValue();
            }
        }
        return result.toString();
    }
}
