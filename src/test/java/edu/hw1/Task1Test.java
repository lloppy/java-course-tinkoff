package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task1Test {

    @Test
    @DisplayName("Подаются только секунды")
    void minutesToSeconds_sec() {
        // given
        String time = "00:33";

        // when
        int returnedSeconds = Task1.minutesToSeconds(time);

        // then
        assertThat(returnedSeconds)
            .isEqualTo(33);
    }

    @Test
    @DisplayName("Подаются только минуты")
    void minutesToSeconds_minutes() {
        // given
        String time = "33:00";

        // when
        int returnedSeconds = Task1.minutesToSeconds(time);

        // then
        assertThat(returnedSeconds)
            .isEqualTo(33 * 60);
    }

    @Test
    @DisplayName("Подаются секунды и минуты меньше 60")
    void minutesToSeconds() {
        // given
        String time = "13:56";

        // when
        int returnedSeconds = Task1.minutesToSeconds(time);

        // then
        assertThat(returnedSeconds)
            .isEqualTo(836);
    }

    @Test
    @DisplayName("Не подаются секунды")
    void minutesToSeconds_inputError() {
        // given
        String time = "01:";

        // when
        int returnedSeconds = Task1.minutesToSeconds(time);

        // then
        assertThat(returnedSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Подаются секунды неменьше 60")
    void minutesToSeconds_secondsError() {
        // given
        String time = "10:60";

        // when
        int returnedSeconds = Task1.minutesToSeconds(time);

        // then
        assertThat(returnedSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Подаются минуты неменьше 60")
    void minutesToSeconds_longMinutes() {
        // given
        String time = "999:09";

        // when
        int returnedSeconds = Task1.minutesToSeconds(time);

        // then
        assertThat(returnedSeconds)
            .isEqualTo(999 * 60 + 9);
    }
}
