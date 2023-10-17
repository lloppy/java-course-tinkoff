package edu.hangman.repository.data;

import edu.hangman.words.WordsUtil;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class WordsUtilTest {


    @Test
    void testThatGetRandomWordReturnedNotEmptyWord() {
        String[] words = {"Java", "Class", "Android"};
        WordsUtil wordsUtil = new WordsUtil();

        String randomWord = wordsUtil.getRandomWord(words);

        assertEquals(false, randomWord.isEmpty());
    }

    @Test
    void testThatGetRandomWordReturnedOneElement() {
        String[] words = {"Java"};
        WordsUtil wordsUtil = new WordsUtil();

        String randomWord = wordsUtil.getRandomWord(words);

        assertEquals("Java", randomWord);
    }

    @Test
    void getUniqueCharacters() {
        String word = "Java";
        WordsUtil wordsUtil = new WordsUtil();

        Set<Character> lettersInWord = wordsUtil.getUniqueCharacters(word);

        assertEquals(3, lettersInWord.size());
    }

    @Test
    void getEmptyUniqueCharacters() {
        String[] words = {"", "", ""};
        WordsUtil wordsUtil = new WordsUtil();

        String randomWord = wordsUtil.getRandomWord(words);
        Set<Character> lettersInWord = wordsUtil.getUniqueCharacters(randomWord);

        assertEquals(0, lettersInWord.size());
    }
}
