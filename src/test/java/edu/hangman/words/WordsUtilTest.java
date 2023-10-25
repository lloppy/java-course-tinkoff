package edu.hangman.words;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testGetIndexesArrayWithRepeatingCharacters() {
        String hiddenWord = "banana";
        char character = 'a';
        List<Integer> indexes = WordsUtil.getIndexesArray(hiddenWord, character);

        assertEquals(3, indexes.size());
        assertEquals(1, indexes.get(0).intValue());
        assertEquals(3, indexes.get(1).intValue());
        assertEquals(5, indexes.get(2).intValue());
    }

    @Test
    void testGetIndexesArrayWithEmptyString() {
        String hiddenWord = "";
        char character = 'a';
        List<Integer> indexes = WordsUtil.getIndexesArray(hiddenWord, character);

        assertTrue(indexes.isEmpty());
    }

    @Test
    void testGetIndexesArrayWithCharacterNotInString() {
        String hiddenWord = "sting with no з";
        char character = 'z';
        List<Integer> indexes = WordsUtil.getIndexesArray(hiddenWord, character);

        assertTrue(indexes.isEmpty());
    }
}
