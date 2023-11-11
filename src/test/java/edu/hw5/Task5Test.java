package edu.hw5;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void validateGoodLicensePlates() {
        List<String> passwords = List.of(
            "А123ВЕ777",
            "О777ОО177"
        );

        for (int i = 0; i < passwords.size(); i++) {
            assertEquals(true, Task5.validateLicensePlates(passwords.get(i)));
        }
    }

    @Test
    void validateWrongLicensePlates() {
        List<String> passwords = List.of(
            "123АВЕ777",
            "А123ВГ77",
            "А123ВЕ7777"
        );

        for (int i = 0; i < passwords.size(); i++) {
            assertEquals(false, Task5.validateLicensePlates(passwords.get(i)));
        }
    }
}
