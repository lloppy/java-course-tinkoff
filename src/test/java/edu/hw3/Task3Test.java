package edu.hw3;

import java.util.Map;
import org.junit.jupiter.api.Test;
import static edu.hw3.task3.Task3.freqDict;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task3Test {

    @Test
    void testThatFreqDictReturnsWordFrequencies() {
        Map<String, Integer> dictionary = freqDict(new String[] {"a", "bb", "a", "bb"});
        assertEquals(2, dictionary.get("bb"));
        assertEquals(2, dictionary.get("a"));
    }

    @Test
    void testThatFreqDictWithDuplicatesReturnsTwoWords() {
        Map<String, Integer> dictionary = freqDict(new String[] {"this", "and", "that", "and"});

        assertEquals(2, dictionary.get("and"));
    }

    @Test
    void testThatFreqDictWithDuplicatesReturnsThreeWords() {
        Map<String, Integer> dictionary = freqDict(new String[] {"код", "код", "код", "code"});
        assertEquals(3, dictionary.get("код"));
    }

    @Test
    void testThatFreqDictReturnsIntegerFrequencies() {
        Map<Integer, Integer> dictionary = freqDict(new Integer[] {1, 1, 2, 2});
        assertEquals(2, dictionary.get(1));
        assertEquals(2, dictionary.get(2));
    }

    @Test
    void testThatFreqDictReturnsEmptyMapForEmptyArray() {
        Map<String, Integer> dictionary = freqDict(new String[0]);
        assertTrue(dictionary.isEmpty());
    }

    @Test
    void testThatFreqDictReturnsSingleWord() {
        Map<String, Integer> dictionary = freqDict(new String[] {"Harry"});
        assertEquals(1, dictionary.get("Harry"));
    }

    @Test
    void testThatFreqDictReturnsNullForNoExistingWord() {
        Map<String, Integer> dictionary = freqDict(new String[] {"Dumbledore", "Hermione", "Ron"});
        assertEquals(null, dictionary.get("Voldemort"));
    }

}
