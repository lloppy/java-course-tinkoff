package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task2 {

    public static Path cloneFile(Path originalPath) throws IOException {
        String newPathName = choosePattern(originalPath.toString());
        return Paths.get(newPathName);
    }

    private static String choosePattern(String string) {
        String patternForDuplicate = "^(.*)( — копия )\\((\\d+)\\)(\\.txt)$";
        String patternForSecondCopy = "^(.*)( — копия)(\\.txt)$";
        String patternForFirstCopy = "^(.*)(\\.txt)$";

        if (string.matches(patternForDuplicate)) {
            return concatenate(string, 4);
        } else if (string.matches(patternForSecondCopy)) {
            return concatenate(string, 3);
        } else if (string.matches(patternForFirstCopy)) {
            return concatenate(string, 2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static String concatenate(String input, int groupCount) {
        Pattern pattern = Pattern.compile("^(.*?)( — копия )?\\(?(\\d+)?\\)?(\\.txt)$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String prefix = matcher.group(1);
            String copySuffix = matcher.group(2);
            String originalNumber = matcher.group(3);
            String fileExtension = matcher.group(4);

            if (groupCount == 4) {
                int newNumber = originalNumber == ".txt" ? 1 : Integer.parseInt(originalNumber) + 1;
                return prefix + copySuffix + "(" + newNumber + ")" + fileExtension;
            } else if (groupCount == 3) {
                return prefix + " (2)" + fileExtension;
            } else if (groupCount == 2) {
                return prefix + " — копия" + fileExtension;
            }
        }

        return "No matches";
    }
}
