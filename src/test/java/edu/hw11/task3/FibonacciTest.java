package edu.hw11.task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @Test
    void testFibonacciMethod() throws Exception {
        // given
        Class<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .implement(Fibonacci.class)
            .method(ElementMatchers.named("fib"))
            .intercept(MethodDelegation.to(FibonacciMethod.class))
            .make()
            .load(FibonacciTest.class.getClassLoader())
            .getLoaded();

        // when
        Fibonacci fibonacci = (Fibonacci) dynamicType.getDeclaredConstructor().newInstance();
        long result = fibonacci.fib(10);
        long result2 = fibonacci.fib(17);

        // then
        assertEquals(result, 55);
        assertEquals(result2, 1597);
    }

    public static class FibonacciMethod {
        public static long fib(final int number) {
            if (number <= 1) {
                return number;
            }
            return fib(number - 1) + fib(number - 2);
        }
    }

    public interface Fibonacci {
        long fib(final int number);
    }
}
