package edu.hangman.model;

import edu.hangman.words.Word;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordTest {

    @Test
    void testThatIsLowerCharInWordReturnedTrue() {
        String[] words = {"Java", "Class", "Android"};
        Word word = new Word(words);

        boolean isInWord = word.isCharInWord('a');

        assertEquals(true, isInWord);
    }

    @Test
    void testThatIsUpperCharInWordReturnedTrue() {
        String[] words = {"Java", "Class"};
        Word word = new Word(words);

        boolean isInWord = word.isCharInWord('A');

        assertEquals(true, isInWord);
    }

    @Test
    void testThatIsCharInWordReturnedFalse() {
        String[] words = {"Java", "Class", "Android"};
        Word word = new Word(words);

        boolean isInWord = word.isCharInWord('z');

        assertEquals(false, isInWord);
    }

    /*
    @Test
    void addGuessedLetter() {
        String[] words = {"Java", "Class", "Android"};
        Word word = new Word(words);

        char letter = 'a';
        word.addGuessedLetter(letter);

        assertEquals(true, word.guessedLetters.get(0) == letter);
    } */

}
