package edu.hw11.task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import org.junit.jupiter.api.Test;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteBuddyTest {

    @Test
    public void createClassWithToString() throws Exception {
        // given
        String expectedGreeting = "Hello, ByteBuddy!";

        Class<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .method(named("toString"))
            .intercept(FixedValue.value(expectedGreeting))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        // when
        Object instance = dynamicType.getDeclaredConstructor().newInstance();
        System.out.println(instance);

        // then
        assertEquals(instance.toString(), expectedGreeting);
    }
}
