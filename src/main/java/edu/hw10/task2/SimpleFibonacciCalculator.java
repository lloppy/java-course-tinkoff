package edu.hw10.task2;

class SimpleFibonacciCalculator implements FibonacciCalculator {
    SimpleFibonacciCalculator() {
    }

    @Override
    public long fibonacci(final int number) {
        if (number <= 1) {
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
