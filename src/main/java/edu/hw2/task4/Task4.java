package edu.hw2.task4;

public final class Task4 {

    private Task4() {
    }

    public record CallingInfo(String className, String methodName) {
    }

    public static CallingInfo getCallingInfo(final int orderOfElement) {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();

        if (orderOfElement < 0 || orderOfElement >= stack.length) {
            throw new IllegalArgumentException(
                "orderOfElement must be between 0 and " + (stack.length)
            );
        }

        return new CallingInfo(
            stack[orderOfElement].getClassName(),
            stack[orderOfElement].getMethodName()
        );
    }
}

