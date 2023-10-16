package edu.hangman.model;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordTest {

    @Test
    void testThatWordsArrayContainsWord() {
        Word word = new Word();
        String[] words = {"Java", "Class", "Android"};

        assertEquals(true, Arrays.asList(words).contains(word.getWord()));
    }

    @Test
    void testThatIsLowerCharInWordReturnedTrue() {
        Word word = new Word();
        boolean isInWord = word.
            isCharInWord(Character.toLowerCase('a'));

        assertEquals(true, isInWord);
    }

    @Test
    void testThatIsUpperCharInWordReturnedTrue() {
        Word word = new Word();
        boolean isInWord = word.
            isCharInWord(Character.toLowerCase('A'));

        assertEquals(true, isInWord);
    }

    @Test
    void testThatIsCharInWordReturnedFalse() {
        Word word = new Word();
        boolean isInWord = word.
            isCharInWord(Character.toLowerCase('z'));

        assertEquals(false, isInWord);
    }

    @Test
    void testThatGuessedLettersContainsAddedValue() {
        Word word = new Word();
        char letter = 'A';
        int expectedSize = 1;

        boolean isInWord = word.isCharInWord(Character.toLowerCase(letter));

        if (isInWord) {
            word.addGuessedLetter(letter);
        }

        assertEquals(expectedSize, word.getGuessedLetters().size());
    }

    @Test
    void testThatGuessedLettersContainsNothing() {
        Word word = new Word();
        char letter = 'z';
        int expectedSize = 0;

        boolean isInWord = word.isCharInWord(Character.toLowerCase(letter));

        if (isInWord) {
            word.addGuessedLetter(letter);
        }

        assertEquals(expectedSize, word.getGuessedLetters().size());
    }

}
