package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task2Test {

    @Test
    @DisplayName("Верный ввод")
    void countDigits_correct1() {
        int number = 4666;
        int total_char = Task2.countDigits(number);
        assertThat(total_char).isEqualTo(4);
    }

    @Test
    @DisplayName("Дает ноль -> возвращает 1")
    void countDigits_givesZero() {
        int number = 0;
        int total_char = Task2.countDigits(number);
        assertThat(total_char).isEqualTo(1);
    }

    @Test
    @DisplayName("Верный ввод 2")
    void countDigits_correct2() {
        int number = 544;
        int total_char = Task2.countDigits(number);
        assertThat(total_char).isEqualTo(3);
    }

    @Test
    @DisplayName("Дает отрицательное число")
    void countDigits_() {
        int number = -544;
        int total_char = Task2.countDigits(number);
        assertThat(total_char).isEqualTo(3);
    }
}
