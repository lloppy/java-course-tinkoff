package edu.hw8.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTaskTest {

    @Test
    void getFibonacciFrom6() {
        int answer = FibonacciTask.getFibonacci(6);

        assertEquals(8, answer);
    }

    @Test
    void getFibonacciFrom5() {
        int answer = FibonacciTask.getFibonacci(5);

        assertEquals(5, answer);
    }

    @Test
    void getFibonacciFrom4() {
        int answer = FibonacciTask.getFibonacci(4);

        assertEquals(3, answer);
    }

    @Test
    void getFibonacciFrom46() {
        int answer = FibonacciTask.getFibonacci(46);

        assertEquals(1836311903, answer);
    }

    @Test
    void getFibonacciFrom40() {
        int answer = FibonacciTask.getFibonacci(40);

        assertEquals(102334155, answer);
    }
}
