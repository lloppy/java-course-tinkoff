package edu.hangman.words;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WordsUtil {

    public final String getRandomWord(String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    public final Set<Character> getUniqueCharacters(String word) {
        Set<Character> uniqueCharactersSet = new HashSet<>();

        for (char c : word.toCharArray()) {
            uniqueCharactersSet.add(c);
        }

        return uniqueCharactersSet;
    }
}
