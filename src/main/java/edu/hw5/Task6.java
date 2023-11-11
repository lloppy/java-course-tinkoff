package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {
    }

    public static boolean isSubsequence(
        final String givenString,
        final String sequence
    ) {
        Pattern pattern = Pattern.compile(".*" + givenString + ".*");
        Matcher matcher = pattern.matcher(sequence);

        return matcher.matches();
    }
}
