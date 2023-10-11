package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task3Test {

    @Test
    @DisplayName("Вложен, ищем по максимуму")
    void testThatIsNestableReturnsTrueWhenSearchingByMaximum() {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {0, 6};
        Boolean isNestable = Task3.isNestable(a1, a2);
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("Вложен, ищем по максимуму или минимуму")
    void testThatIsNestableReturnsTrueWhenSearchingByMaximumOrMinimum() {
        int[] a1 = {3, 1};
        int[] a2 = {4, 0};
        Boolean isNestable = Task3.isNestable(a1, a2);
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("Не вложен, одинаковые значения максимума и минимума")
    void testThatIsNestableReturnsFalseWhenMaximumAndMinimumValuesAreEqual() {
        int[] a1 = {9, 9, 8};
        int[] a2 = {8, 9};
        Boolean isNestable = Task3.isNestable(a1, a2);
        assertThat(isNestable).isEqualTo(false);
    }

    @Test
    @DisplayName("Не вложен, минимум меньше, максимум больше")
    void testThatIsNestableReturnsFalseWhenMinimumIsSmallerAndMaximumIsLarger() {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {2, 3};
        Boolean isNestable = Task3.isNestable(a1, a2);
        assertThat(isNestable).isEqualTo(false);
    }

    @Test
    @DisplayName("Вложен, ищем по минимуму")
    void testThatIsNestableReturnsTrueWhenSearchingByMinimum() {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {-1, 3};
        Boolean isNestable = Task3.isNestable(a1, a2);
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("Подаются два пустых массива")
    void testThatIsNestableReturnsFalseWhenBothArraysAreEmpty() {
        int[] a1 = {};
        int[] a2 = {};
        Boolean isNestable = Task3.isNestable(a1, a2);
        assertThat(isNestable).isEqualTo(false);
    }

    @Test
    @DisplayName("Один из массивов пустой")
    void testThatIsNestableReturnsFalseWhenOneArrayIsEmpty() {
        int[] a1 = {};
        int[] a2 = {12, 3, 14};
        Boolean isNestable = Task3.isNestable(a1, a2);
        assertThat(isNestable).isEqualTo(false);
    }
}
