package edu.hangman.words;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    public static List<Integer> getIndexesArray(String hiddenWord, char character) {
        Character upper = Character.toUpperCase(character);
        Character lower = Character.toLowerCase(character);

        List<Integer> charArray = new ArrayList<>();

        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == upper || hiddenWord.charAt(i) == lower) {
                charArray.add(i);
            }
        }

        return charArray;
    }
}
