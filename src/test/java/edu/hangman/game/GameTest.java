package edu.hangman.game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void testThatSameInputAndExpectedAreEquals()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method inputLetterMethod = Game.class.getDeclaredMethod("inputLetter");
        inputLetterMethod.setAccessible(true);

        String simulatedInput = "a\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        char inputLetter = (char) inputLetterMethod.invoke(null);

        System.setIn(System.in);

        assertEquals('a', inputLetter);
    }

    @Test
    void testThatDifferentInputAndExpectedAreNotTheSame()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method inputLetterMethod = Game.class.getDeclaredMethod("inputLetter");
        inputLetterMethod.setAccessible(true);

        String simulatedInput = "b\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        char inputLetter = (char) inputLetterMethod.invoke(null);

        System.setIn(System.in);

        assertEquals(false, 'a' == inputLetter);
    }

    @Test
    void testThatLongInputThrowError() {
        boolean isException = false;
        try {
            String longString = "long string";
            inputLetterCopy(longString);
        } catch (IllegalArgumentException e) {
            isException = true;
        }
        assertEquals(true, isException);
    }

    @Test
    void testThatShortInputDontThrowError() {
        boolean isException = false;
        try {
            String longString = "a";
            inputLetterCopy(longString);
        } catch (IllegalArgumentException e) {
            isException = true;
        }
        assertEquals(false, isException);

    }


    private static char inputLetterCopy(String string) {
        String input = string;

        if (input.length() == 1) {
            return input.charAt(0);
        } else {
            throw new IllegalArgumentException("Вы ввели больше одного символа.");
        }
    }

}
