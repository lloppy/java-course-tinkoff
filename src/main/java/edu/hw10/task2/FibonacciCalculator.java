package edu.hw10.task2;

import edu.hw10.task2.annotations.Cache;

public interface FibonacciCalculator {
    @Cache(persist = true)
    long fibonacci(int number);
}
