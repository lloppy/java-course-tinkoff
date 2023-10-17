package edu.hangman.words;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public final class WordsUtil {
    public WordsUtil() {
    }

    public static String getRandomWord(final String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    public static Set<Character> getUniqueCharacters(final String word) {
        Set<Character> uniqueCharactersSet = new HashSet<>();

        for (char c : word.toCharArray()) {
            uniqueCharactersSet.add(c);
        }

        return uniqueCharactersSet;
    }
}
