package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void rotateRight_1() {
        // when
        var steps = Task7.rotateRight(8, 1);

        // then
        assertThat(steps)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Шифт = 0, число не меняется")
    void rotateRight_2() {
        // when
        var steps = Task7.rotateRight(8, 0);

        // then
        assertThat(steps)
            .isEqualTo(8);
    }

    @Test
    @DisplayName("Шифт = длина числа, число не меняется")
    void rotateRight_3() {
        int log = (int) (Math.log(8.0) / Math.log(2.0));
        // when
        var steps = Task7.rotateRight(8, log + 1 );

        // then
        assertThat(steps)
            .isEqualTo(8);
    }


    @Test
    @DisplayName("Шифт больше длины")
    void rotateRight_4() {
        // when                        1011 - 1110 - 14
        var steps = Task7.rotateRight(11, 6 );

        // then
        assertThat(steps)
            .isEqualTo(14);
    }

    @Test
    void rotateLeft_1() {
        // when
        var steps = Task7.rotateLeft(16, 1);

        // then
        assertThat(steps)
            .isEqualTo(1);
    }

    @Test
    void rotateLeft_2() {
        // when
        var steps = Task7.rotateLeft(17, 2);

        // then
        assertThat(steps)
            .isEqualTo(6);
    }
}
