package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task5Test {

    @Test
    @DisplayName("Палиндром - потомок, четное")
    void testThatEvenPalindromeIsDescendant() {
        // given
        Integer number = 123312;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Само число - палиндром")
    void testThatNumberIsPalindrome() {
        // given
        Integer number = 123321;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Короткое число, суммы равны, но не потомок")
    void testThatShortNumberWithEqualSumIsNotDescendant() {
        // given
        Integer number = 123;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Короткое число - не палиндром")
    void testThatShortNumberIsNotPalindrome() {
        // given
        Integer number = 12;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Палиндром, нечетное")
    void testThatOddPalindromeIsDescendant() {
        // given
        Integer number = 1237321;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Не палиндром, нечетное")
    void testThatOddNumberIsNotPalindrome() {
        // given
        Integer number = 1237312;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Минимально возможный по длине потомок палиндром")
    void testThatMinimumLengthDescendantPalindrome() {
        // given
        Integer number = 1203;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Число длиной 3, но не потомок")
    void testThatShortNumberIsNotDescendant() {
        // given
        Integer number = 734;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Длинный потомок палиндром")
    void testThatLongPalindromeDescendant() {
        // given
        Integer number = 13001120;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Длинный не палиндром потомок")
    void testThatLongNonPalindromeDescendant() {
        // given
        Integer number = 23336014;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Число из одной цифры - потомок палиндром")
    void testThatSingleDigitNumberIsDescendant() {
        // given
        Integer number = 11;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }
}
