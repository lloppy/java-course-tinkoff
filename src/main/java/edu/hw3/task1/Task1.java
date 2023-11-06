package edu.hw3.task1;

public final class Task1 {
    private Task1() {
    }

    public static String atbash(final String startString) {
        StringBuilder decoded = new StringBuilder();

        for (char currentChar : startString.toCharArray()) {
            if (Character.isLetter(currentChar)) {
                int newChar = Character.isLowerCase(currentChar)
                    ? ('z' - currentChar) + 'a'
                    : ('Z' - currentChar) + 'A';
                decoded.append((char) newChar);
            } else {
                decoded.append(currentChar);
            }
        }
        return decoded.toString();
    }
}
