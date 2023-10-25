package edu.hangman.words;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordTest {

    @Test
    void testThatIsLowerCharInWordReturnedTrue() {
        String[] words = {"Java", "Class", "Android"};
        Word word = new Word(words);

        assertTrue(word.isCharInWord('a'));
    }

    @Test
    void testThatIsUpperCharInWordReturnedTrue() {
        String[] words = {"Java", "Class"};
        Word word = new Word(words);

        assertTrue(word.isCharInWord('A'));
    }

    @Test
    void testThatIsCharInWordReturnedFalse() {
        String[] words = {"Java", "Class", "Android"};
        Word word = new Word(words);

        assertFalse(word.isCharInWord('z'));
    }
}
