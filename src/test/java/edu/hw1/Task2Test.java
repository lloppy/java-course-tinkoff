package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("Correct input")
    void countDigits_correct1() {
        // given
        int number = 4666;

        //when
        int total_char = Task2.countDigits(number);

        // then
        assertThat(total_char)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Gives zero -> return 1")
    void countDigits_givesZero() {
        // given
        int number = 0;

        //when
        int total_char = Task2.countDigits(number);

        // then
        assertThat(total_char)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Gives zero -> return 1")
    void countDigits_correct2() {
        // given
        int number = 544;

        //when
        int total_char = Task2.countDigits(number);

        // then
        assertThat(total_char)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Gives negative number")
    void countDigits_() {
        // given
        int number = -544;

        //when
        int total_char = Task2.countDigits(number);

        // then
        assertThat(total_char)
            .isEqualTo(3);
    }

}
