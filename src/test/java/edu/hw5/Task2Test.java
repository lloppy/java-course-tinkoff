package edu.hw5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    @Test
    void testThatFindFridaysFor1925ReturnedExpected() {
        List<LocalDate> fridays = Task2.findFridays(1925);

        // 1925-02-13, 1925-03-13, 1925-11-13
        List<LocalDate> expected = new ArrayList<>();
        expected.add(LocalDate.of(1925, 2, 13));
        expected.add(LocalDate.of(1925, 3, 13));
        expected.add(LocalDate.of(1925, 11, 13));

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), fridays.get(i));
        }
        assertEquals(expected.size(), fridays.size());
    }

    @Test
    void testThatFindFridaysFor2024ReturnedExpected() {
        List<LocalDate> fridays = Task2.findFridays(2024);

        // 2024-09-13, 2024-12-13
        List<LocalDate> expected = new ArrayList<>();
        expected.add(LocalDate.of(2024, 9, 13));
        expected.add(LocalDate.of(2024, 12, 13));

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), fridays.get(i));
        }
        assertEquals(expected.size(), fridays.size());
    }
}
