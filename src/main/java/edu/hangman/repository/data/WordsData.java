package edu.hangman.repository.data;

import java.util.Random;

public class WordsData implements GameDatabase {

    private final String[] words = {"Java", "Class", "Android"};

    @Override
    public final String[] getWordsDatabase() {
        return words;
    }

    @Override
    public final String getRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
}
