package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.task4.Task4.convertToRoman;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {

    @Test
    void testThatConvertToRomanReturnsII() {
        String romanInt = convertToRoman(2);
        String expected = "II";

        assertEquals(expected, romanInt);
    }

    @Test
    void testThatConvertToRomanReturnsXII() {
        String romanInt = convertToRoman(12);
        String expected = "XII";

        assertEquals(expected, romanInt);
    }

    @Test
    void testThatConvertToRomanReturnsXVI() {
        String romanInt = convertToRoman(16);
        String expected = "XVI";

        assertEquals(expected, romanInt);
    }

    @Test
    void testThatConvertToRomanReturnsIV() {
        String romanInt = convertToRoman(4);
        String expected = "IV";

        assertEquals(expected, romanInt);
    }

    @Test
    void testThatConvertToRomanReturnsIX() {
        String romanInt = convertToRoman(9);
        String expected = "IX";

        assertEquals(expected, romanInt);
    }

    @Test
    void testThatConvertToRomanReturnsXXIX() {
        String romanInt = convertToRoman(29);
        String expected = "XXIX";

        assertEquals(expected, romanInt);
    }

    @Test
    void testThatConvertToRomanReturnsXLIV() {
        String romanInt = convertToRoman(44);
        String expected = "XLIV";

        assertEquals(expected, romanInt);
    }

    @Test
    void testThatConvertToRomanReturnsMMMCMXCIX() {
        String romanInt = convertToRoman(3999);
        String expected = "MMMCMXCIX";

        assertEquals(expected, romanInt);
    }
}
