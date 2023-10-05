package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    @DisplayName("3524 -> 3")
    void kaprekar_1() {
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
    void kaprekar_2() {
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
    void kaprekar_3() {
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
    void kaprekar_4() {
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
    void kaprekar_5() {
        // given
        int number = 123;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Невалидный ввод - бльше символов")
    void kaprekar_6() {
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
    void kaprekar_7() {
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
    void kaprekar_8() {
        // given
        int number = 6174;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("2005 -> 7 - макс число шагов")
    void kaprekar_9() {
        // given
        int number = 2005;

        // when
        var steps = Task6.realization(number);
        // then
        assertThat(steps)
            .isEqualTo(7);
    }

}
