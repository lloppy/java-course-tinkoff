package edu.hw11.task2;

import java.lang.reflect.Method;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticUtilsTest {

    @Test
    void multiplicationInsteadOfSum() throws Exception {
        // given
        Class<?> dynamicType = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum"))
            .intercept(MethodDelegation.to(SumClass.class))
            .make()
            .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.INJECTION)
            .getLoaded();

        // when
        Method sumMethod = dynamicType.getMethod("sum", int.class, int.class);
        int result = (int) sumMethod.invoke(dynamicType.getDeclaredConstructor().newInstance(), 10, 17);
        int result2 = (int) sumMethod.invoke(dynamicType.getDeclaredConstructor().newInstance(), 4, 50);

        // then
        assertEquals(result, 170);
        assertEquals(result2, 200);
    }

    public static class SumClass {
        public static int sum(final int a, final int b) {
            return a * b;
        }
    }
}
