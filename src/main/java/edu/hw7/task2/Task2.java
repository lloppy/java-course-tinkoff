package edu.hw7.task2;

import java.math.BigInteger;
import java.util.stream.LongStream;

public final class Task2 {
    private Task2() {
    }

    public static BigInteger getFactorial(final long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Your number is negative!");
        }
        return LongStream
            .rangeClosed(1, n)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .reduce(
                BigInteger.ONE,
                BigInteger::multiply
            );
    }
}
