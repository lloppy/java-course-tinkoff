package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task5Test {

    @Test
    @DisplayName("Палиндром - потомок, четное")
    void isPalindromeDescendant_1() {
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
    void isPalindromeDescendant_2() {
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
    void isPalindromeDescendant_3() {
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
    void isPalindromeDescendant_4() {
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
    void isPalindromeDescendant_5() {
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
    void isPalindromeDescendant_6() {
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
    void isPalindromeDescendant_7() {
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
    void isPalindromeDescendant_8() {
        // given
        Integer number = 734;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(false);
    }

    @Test
    void isPalindromeDescendant_9() {
        // given
        Integer number = 13001120;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

    @Test
    void isPalindromeDescendant_10() {
        // given
        Integer number = 23336014;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

    @Test
    void isPalindromeDescendant_11() {
        // given
        Integer number = 11;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindrome)
            .isEqualTo(true);
    }

}
