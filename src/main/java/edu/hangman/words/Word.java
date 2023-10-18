package edu.hangman.words;

import edu.hangman.ui.Messages;
import java.util.List;
import java.util.Set;

public class Word {

    private static String hiddenWord;
    private static Set<Character> letterInWord;
    private StringBuilder guessedString;

    public Word(final String[] words) {
        WordsUtil wordsUtil = new WordsUtil();

        this.hiddenWord = wordsUtil.getRandomWord(words);
        this.letterInWord = wordsUtil.getUniqueCharacters(hiddenWord);
        this.guessedString = new StringBuilder("_".repeat(hiddenWord.length()));

        Messages.startGame(String.valueOf(guessedString));
    }

    public final boolean isCharInWord(final char letter) {
        Character upper = Character.toUpperCase(letter);
        Character lower = Character.toLowerCase(letter);

        if (letterInWord.contains(upper) || letterInWord.contains(lower)) {

            List<Integer> indexesArray = WordsUtil.getIndexesArray(hiddenWord, lower);

            for (int index : indexesArray) {
                guessedString.setCharAt(index, hiddenWord.charAt(index));
                // _ _ _ _ _
                // 1 3 5 7 9
                // 0 2 4 6 8
            }

            letterInWord.remove(letterInWord.contains(upper) ? upper : lower);
            return true;
        }
        return false;

    }

    public String getHiddenString() {
        return String.valueOf(guessedString);
    }

    public static final boolean isSolved() {
        return 0 == letterInWord.size();
    }
}