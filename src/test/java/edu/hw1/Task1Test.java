package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task1Test {

    @Test
    @DisplayName("Подаются только секунды")
    void testThatSecondsAreReturnedWhenOnlySecondsAreProvided() {
        String time = "00:33";
        int returnedSeconds = Task1.minutesToSeconds(time);
        assertThat(returnedSeconds).isEqualTo(33);
    }

    @Test
    @DisplayName("Подаются только минуты")
    void testThatSecondsAreReturnedWhenOnlyMinutesAreProvided() {
        String time = "33:00";
        int returnedSeconds = Task1.minutesToSeconds(time);
        assertThat(returnedSeconds).isEqualTo(33 * 60);
    }

    @Test
    @DisplayName("Подаются секунды и минуты меньше 60")
    void testThatSecondsAreReturnedWhenMinutesAndSecondsAreLessThan60() {
        String time = "13:56";
        int returnedSeconds = Task1.minutesToSeconds(time);
        assertThat(returnedSeconds).isEqualTo(836);
    }

    @Test
    @DisplayName("Не подаются секунды")
    void testThatInputErrorReturnsMinusOne() {
        String time = "01:";
        int returnedSeconds = Task1.minutesToSeconds(time);
        assertThat(returnedSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Подаются секунды неменьше 60")
    void testThatSecondsErrorReturnsMinusOne() {
        String time = "10:60";
        int returnedSeconds = Task1.minutesToSeconds(time);
        assertThat(returnedSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Подаются минуты неменьше 60")
    void testThatSecondsAreReturnedWhenMinutesAreAtLeast60() {
        String time = "999:09";
        int returnedSeconds = Task1.minutesToSeconds(time);
        assertThat(returnedSeconds).isEqualTo(999 * 60 + 9);
    }

    @Test
    @DisplayName("Подаются буквы abc:abc")
    void testThatInputErrorReturnsMinusOneLetters() {
        String wrongTime = "abc:abc";
        int returnedSeconds = Task1.minutesToSeconds(wrongTime);
        assertThat(returnedSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Подаются буквы ab:ab")
    void testThatInputErrorReturnsMinusOneLetters2() {
        String wrongTime = "ab:ab";
        int returnedSeconds = Task1.minutesToSeconds(wrongTime);
        assertThat(returnedSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Подаются буквы и цифры")
    void testThatInputErrorReturnsMinusOneLetters3() {
        String wrongTime = "1a:13";
        int returnedSeconds = Task1.minutesToSeconds(wrongTime);
        assertThat(returnedSeconds).isEqualTo(-1);
    }
}
