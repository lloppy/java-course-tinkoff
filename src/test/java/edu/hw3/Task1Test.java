package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.task1.Task1.atbash;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @Test
    void testThatAtbashWithAllLowerReturnLowerString() {
        String startString = "hello world!";

        String atbashString = atbash(startString);
        String expected = "svool dliow!";

        assertEquals(expected, atbashString);
    }

    @Test
    void testThatAtbashWithAllUpperReturnUpperString() {
        String startString = "GOODMORNING!";

        String atbashString = atbash(startString);
        String expected = "TLLWNLIMRMT!";

        assertEquals(expected, atbashString);
    }

    @Test
    void testThatAtbashWithMixReturnMixString() {
        String startString = "Hello world!";

        String atbashString = atbash(startString);
        String expected = "Svool dliow!";

        assertEquals(expected, atbashString);
    }

    @Test
    void testThatAtbashWithLongStringReturnCorrectAnswer() {
        String startString =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";

        String atbashString = atbash(startString);
        String expected =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        assertEquals(expected, atbashString);
    }

    @Test
    void testThatAtbashWithNoLettersReturnTheStartString() {
        String startString = "!!!";

        String atbashString = atbash(startString);
        String expected = "!!!";

        assertEquals(expected, atbashString);
    }

    @Test
    void testThatAtbashWithEmptyStringReturnEmptyString() {
        String startString = "";

        String atbashString = atbash(startString);
        String expected = "";

        assertEquals(expected, atbashString);
    }
}
