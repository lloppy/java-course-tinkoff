package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task4Test {

    @Test
    @DisplayName("Подаются различные числа")
    void fixString_1() {
        String brokenString = "123456";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString)
            .isEqualTo("214365");
    }

    @Test
    @DisplayName("Подаются различные символы")
    void fixString_2() {
        String brokenString = "hTsii  s aimex dpus rtni.g";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString)
            .isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Подается нечетная по длине строка")
    void fixString_3() {
        String brokenString = "badce";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString)
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Подается строка с пробелами")
    void fixString_4() {
        String brokenString = "a b c d e";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString)
            .isEqualTo(" a b c de");
    }

    @Test
    @DisplayName("Подается строка из одого символа")
    void fixString_5() {
        String brokenString = "a";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString)
            .isEqualTo("a");
    }

    @Test
    @DisplayName("Подается пустая строка")
    void fixString_6() {
        String brokenString = "";

        String fixedString = Task4.fixString(brokenString);

        assertThat(fixedString)
            .isEqualTo("");
    }
}
