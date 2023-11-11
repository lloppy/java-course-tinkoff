package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void testThatMatchesThreeZeroPatternReturnedTrue() {
        assertTrue(Task7.matchesThreeZeroPattern("01010"));
    }

    @Test
    void testThatMatchesThreeZeroWithOnePatternReturnedFalse() {
        assertFalse(Task7.matchesThreeZeroPattern("11111"));
    }

    @Test
    void testThatMatchesThreeZeroShortPatternReturnedFalse() {
        assertFalse(Task7.matchesThreeZeroPattern("11"));
    }

    @Test
    void testThatMatchesSymmetricPatternReturnedTrue() {
        assertTrue(Task7.matchesSymmetricPattern("01010"));
    }

    @Test
    void testThatMatchesSymmetricPatternReturnedFalse() {
        assertFalse(Task7.matchesSymmetricPattern("11010"));
    }

    @Test
    void testThatMatchesShortPatternReturnedTrue() {
        assertTrue(Task7.matchesShortPattern("010"));
    }

    @Test
    void testThatMatchesShortPatternReturnedFalse() {
        assertFalse(Task7.matchesShortPattern("01010"));
    }
}
