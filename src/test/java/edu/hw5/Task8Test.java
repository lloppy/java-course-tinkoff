package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task8Test {

    @Test
    void testThatMatchesOddLengthPatternReturnedTrue() {
        assertTrue(Task8.matchesOddLengthPattern("010"));
        assertTrue(Task8.matchesOddLengthPattern("101"));
        assertFalse(Task8.matchesOddLengthPattern("0100"));
    }

    @Test
    void testThatMatchesZeroOddOrOneEvenPatternReturnedTrue() {
        assertTrue(Task8.matchesZeroOddOrOneEvenPattern("011"));
        assertTrue(Task8.matchesZeroOddOrOneEvenPattern("1010"));
        assertFalse(Task8.matchesZeroOddOrOneEvenPattern("0101"));
        assertFalse(Task8.matchesZeroOddOrOneEvenPattern("110"));
    }

    @Test
    void testThatMatchesMultipleOfThreeZerosPatternReturnedTrue() {
        assertTrue(Task8.matchesMultipleOfThreeZerosPattern("01010"));
        assertTrue(Task8.matchesMultipleOfThreeZerosPattern("100101000"));
        assertFalse(Task8.matchesMultipleOfThreeZerosPattern("01011"));
    }

    @Test
    void testThatMatchesExcept11Or111PatternReturnedTrue() {
        assertTrue(Task8.matchesExcept11Or111Pattern("0101"));
        assertTrue(Task8.matchesExcept11Or111Pattern("1000000001"));
        assertFalse(Task8.matchesExcept11Or111Pattern("11"));
        assertFalse(Task8.matchesExcept11Or111Pattern("111"));
    }

    @Test
    void testThatMatchesNoConsecutiveOnesPatternReturnedTrue() {
        assertTrue(Task8.matchesNoConsecutiveOnesPattern("01000001"));
        assertTrue(Task8.matchesNoConsecutiveOnesPattern("1010"));
        assertTrue(Task8.matchesNoConsecutiveOnesPattern("10"));
        assertTrue(Task8.matchesNoConsecutiveOnesPattern("00000001000"));
        assertFalse(Task8.matchesNoConsecutiveOnesPattern("110"));
        assertFalse(Task8.matchesNoConsecutiveOnesPattern("0111111"));
    }
}
