package edu.hw7;

import edu.hw7.task1.Task1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    public void testIncrementForLargeValue() throws InterruptedException {
        // given
        Integer limit = 100_000;

        //when
        Integer threadResult = Task1.getThreadsResult(limit);

        //then
        assertEquals(300_000, threadResult);
    }

    @Test
    public void testIncrementForMediumValue() throws InterruptedException {
        // given
        Integer limit = 1_000;

        //when
        Integer threadResult = Task1.getThreadsResult(limit);

        //then
        assertEquals(3_000, threadResult);
    }

    @Test
    public void testIncrementForSmallValue() throws InterruptedException {
        // given
        Integer limit = 10;

        //when
        Integer threadResult = Task1.getThreadsResult(limit);

        //then
        assertEquals(30, threadResult);
    }
}

