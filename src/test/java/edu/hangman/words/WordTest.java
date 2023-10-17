package edu.hangman.words;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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



}
