package edu.hw2;

import edu.hw2.task4.Task4.CallingInfo;
import org.junit.jupiter.api.Test;
import static edu.hw2.task4.Task4.getCallingInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task4Test {
    @Test
    void testThatGetCallingInfoReturnedMainMethodName() {
        int stackDepth = Thread.currentThread().getStackTrace().length;

        CallingInfo callingInfo = getCallingInfo(stackDepth);
        String methodName = "main";

        assertEquals(methodName, callingInfo.methodName());
    }

    @Test
    void testThatGetCallingInfoReturnedJUnitStarterClassName() {
        int stackDepth = Thread.currentThread().getStackTrace().length;

        CallingInfo callingInfo = getCallingInfo(stackDepth);

        String classDir = "JUnitStarter";
        String actualClassName = callingInfo.className();
        int pointPosition = actualClassName.lastIndexOf(".");

        assertEquals(
            classDir,
            actualClassName.substring(pointPosition + 1)
        );
    }

    @Test
    void testThatGetCallingInfoForPreLastElementReturnedThisTestClassName() {
        CallingInfo callingInfo = getCallingInfo(1);

        String classDir = "Task4";
        String actualClassName = callingInfo.className();
        int pointPosition = actualClassName.lastIndexOf(".");

        assertEquals(
            classDir,
            actualClassName.substring(pointPosition + 1)
        );
    }

    @Test
    void testThatGetCallingInfoForPreLastElementReturnedThisTestMethodName() {
        CallingInfo callingInfo = getCallingInfo(1);
        String methodName = "getCallingInfo";

        assertEquals(methodName, callingInfo.methodName());
    }

    @Test
    void testThatGetCallingInfoForLastExecutedMethodReturnedLastClassNameInСallStackTrace() {
        CallingInfo callingInfo = getCallingInfo(0);

        String classDir = "Thread";
        String actualClassName = callingInfo.className();
        int pointPosition = actualClassName.lastIndexOf(".");

        assertEquals(
            classDir,
            actualClassName.substring(pointPosition + 1)
        );
    }

    @Test
    void testThatGetCallingInfoForLastExecutedMethodReturnedLastMethodNameInСallStackTrace() {
        CallingInfo callingInfo = getCallingInfo(0);
        String methodName = "getStackTrace";

        assertEquals(methodName, callingInfo.methodName());
    }

    @Test
    void testThatGetCallingInfoForLessThanStackTraceLengthThrowException() {
        try {
            CallingInfo callingInfo = getCallingInfo(-1);
            String methodName = "outOfBound";

            assertEquals(methodName, callingInfo.methodName());
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void testThatGetCallingInfoMoreThanStackTraceLengthThrowException() {
        try {
            int stackDepth = Thread.currentThread().getStackTrace().length;
            CallingInfo callingInfo = getCallingInfo(stackDepth + 1);

            String classDir = "outOfBound";
            String actualClassName = callingInfo.className();
            int pointPosition = actualClassName.lastIndexOf(".");

            assertEquals(
                classDir,
                actualClassName.substring(pointPosition + 1)
            );
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
