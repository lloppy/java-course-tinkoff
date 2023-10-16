package edu.hangman.model;

import edu.hangman.repository.data.WordsData;
import java.util.ArrayList;
import java.util.List;

public class Word {

    private String word;
    private List<Character> guessedLetters;
    private WordsData wordsData;

    public Word() {
        this.wordsData = new WordsData();
        this.word = wordsData.getRandomWord();
        this.guessedLetters = new ArrayList<>();
    }

    public final boolean isCharInWord(final char letter) {
        String stringLetter = Character.toString(letter);

        String upper = stringLetter.toUpperCase();
        String lower = stringLetter.toLowerCase();

        if (guessedLetters.contains(upper) || guessedLetters.contains(lower)) {
            return true;
        }

        return (word.contains(upper) || word.contains(lower));
    }

    public final void addGuessedLetter(final Character letter) {
        guessedLetters.add(letter);
    }

    public final String getWord() {
        return word;
    }

    public final List<Character> getGuessedLetters() {
        return guessedLetters;
    }

}
