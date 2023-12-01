package edu.hw8.task2;

public class FibonacciTask {

    public static int getFibonacci(int elementNumber) {
        if (elementNumber == 1 || elementNumber == 0) {
            return elementNumber;
        }
        return getFibonacci(elementNumber - 1) + getFibonacci(elementNumber - 2);
    }
}
