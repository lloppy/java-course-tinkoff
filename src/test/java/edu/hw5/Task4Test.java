package edu.hw5;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void checkCorrectPasswords() {
        List<String> passwords = List.of(
            "Hello word~",
            "good password!",
            "lloppy@gmai.com",
            "good#password",
            "good$password",
            "good%password",
            "^good password",
            "good&password",
            "good*password",
            "good|password"
        );

        for (int i = 0; i < passwords.size(); i++) {
            assertEquals(true, Task4.checkPassword(passwords.get(i)));
        }
    }

    @Test
    void checkWrongPasswords() {
        List<String> passwords = List.of(
            "password",
            "12345364",
            "p.a.s.s",
            "/"
            );

        for (int i = 0; i < passwords.size(); i++) {
            assertEquals(false, Task4.checkPassword(passwords.get(i)));
        }
    }
}
