package edu.hangman.words;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class WordsUtilTest {

    @Test
    void testThatGetRandomWordReturnedNotEmptyWord() {
        String[] words = {"Java", "Class", "Android"};
        String randomWord = WordsUtil.getRandomWord(words);

        assertFalse(randomWord.isEmpty());
    }

    @Test
    void testThatGetRandomWordReturnedOneElement() {
        String[] words = {"Java"};
        String randomWord = WordsUtil.getRandomWord(words);

        assertEquals("Java", randomWord);
    }

    @Test
    void testThatGetUniqueCharactersReturnNumberOfUnique() {
        String word = "Java";
        Set<Character> lettersInWord = WordsUtil.getUniqueCharacters(word);

        assertEquals(3, lettersInWord.size());
    }

    @Test
    void testThatGetEmptyUniqueCharactersReturn0() {
        String[] words = {"", "", ""};
        String randomWord = WordsUtil.getRandomWord(words);
        Set<Character> lettersInWord = WordsUtil.getUniqueCharacters(randomWord);

        assertEquals(0, lettersInWord.size());
    }
}
