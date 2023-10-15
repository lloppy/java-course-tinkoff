package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task6Test {

    @Test
    @DisplayName("3524 -> 3")
    void testThatStepsFor3524Are3() {
        // given
        int number = 3524;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("6621 -> 5")
    void testThatStepsFor6621Are5() {
        // given
        int number = 6621;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(5);
    }

    @Test
    @DisplayName("6554 -> 4")
    void testThatStepsFor6554Are4() {
        // given
        int number = 6554;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("1234 -> 3")
    void testThatStepsFor1234Are3() {
        // given
        int number = 1234;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Невалидный ввод - меньше символов")
    void testThatInvalidInputLessDigitsReturnsMinus1() {
        // given
        int number = 123;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Невалидный ввод - больше символов")
    void testThatInvalidInputMoreDigitsReturnsMinus1() {
        // given
        int number = 12345;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Невалидный ввод - все цифры одинаковые")
    void testThatInvalidInputAllDigitsAreSameReturnsMinus1() {
        // given
        int number = 1111;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("6174 -> 0 - число уже 6174")
    void testThatStepsFor6174Are0() {
        // given
        int number = 6174;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("2005 -> 7 - максимальное количество шагов")
    void testThatStepsFor2005Are7() {
        // given
        int number = 2005;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(7);
    }
}
