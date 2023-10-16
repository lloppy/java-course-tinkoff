package edu.hangman.repository.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsDataTest {

    @Test
    void testThatGetRandomWordReturnedNotEmptyWord() {
        WordsData wordsData = new WordsData();
        String randomWord = wordsData.getRandomWord();

        assertEquals(false, randomWord.isEmpty());
    }

    @Test
    void testThatGetWordDatabaseReturnedNotEmptyArray() {
        WordsData wordsData = new WordsData();
        int size = wordsData.getWordsDatabase().length;

        String[] words = {"Java", "Class", "Android"};

        assertEquals(words.length, size);
    }
}
