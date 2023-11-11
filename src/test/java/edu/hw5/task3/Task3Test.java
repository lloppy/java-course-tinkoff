package edu.hw5.task3;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task3Test {

    @Test
    void testThatDashParseDateReturnedCorrectDate(){
        Task3 task3 = new Task3();
        LocalDate date1 = task3.parseDate("2020-10-10").get();
        LocalDate date2 = task3.parseDate("2020-12-02").get();

        Assertions.assertEquals(date1, LocalDate.parse("2020-10-10"));
        Assertions.assertEquals(date2, LocalDate.parse("2020-12-02"));
    }


    @Test
    void testThatSlashParseDateReturnedCorrectDate(){
        Task3 task3 = new Task3();

        LocalDate date3 = task3.parseDate("1/3/1976").get();
        LocalDate date4 = task3.parseDate("3/3/20").get();

        Assertions.assertEquals(date3, LocalDate.parse("1976-03-01"));
        Assertions.assertEquals(date4, LocalDate.parse("2020-03-03"));
    }

    @Test
    void testThatStringParseDateReturnedCorrectDate(){
        Task3 task3 = new Task3();

        LocalDate date5 = task3.parseDate("tomorrow").get();
        LocalDate date6 = task3.parseDate("today").get();
        LocalDate date7 = task3.parseDate("yesterday").get();

        Assertions.assertEquals(date5, LocalDate.now().plusDays(1));
        Assertions.assertEquals(date6, LocalDate.now());
        Assertions.assertEquals(date7, LocalDate.now().minusDays(1));
    }

    @Test
    void testThatMixParseDateReturnedCorrectDate(){
        Task3 task3 = new Task3();

        LocalDate date8 = task3.parseDate("1 day ago").get();
        LocalDate date9 = task3.parseDate("2234 days ago").get();
        LocalDate date10 = task3.parseDate("1 year ago").get();

        Assertions.assertEquals(date8, LocalDate.now().minusDays(1));
        Assertions.assertEquals(date9, LocalDate.now().minusDays(2234));
        Assertions.assertEquals(date10, LocalDate.now().minusYears(1));
    }
}
