package edu.hangman.words;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Word {

    private String word;
    private Set<Character> letterInWord;
    public List<Character> guessedLetters;

    public Word(String[] words) {
        WordsUtil wordsUtil = new WordsUtil();

        this.word = wordsUtil.getRandomWord(words);
        this.letterInWord = wordsUtil.getUniqueCharacters(word);
        this.guessedLetters = new ArrayList<>();

        System.out.println("Слово загадано!");
    }

    public final boolean isCharInWord(final char letter) {
        Character upper = Character.toUpperCase(letter);
        Character lower = Character.toLowerCase(letter);

        if (letterInWord.contains(upper) || letterInWord.contains(lower)) {
            letterInWord.remove(letterInWord.contains(upper) ? upper : lower);
            return true;
        }
        return false;
    }


    public boolean isSolved() {
        return 0 == letterInWord.size();
    }
}
