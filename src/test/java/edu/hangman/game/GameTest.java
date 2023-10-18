package edu.hangman.game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
            String shortInput = "a";
            inputLetterCopy(shortInput);
        } catch (IllegalArgumentException e) {
            isException = true;
        }
        assertEquals(false, isException);
    }

    @Test
    void testThatUserGaveUpReturnTrue() {
        String giveUpMessage = "white flag";
        char emptyChar = inputLetterCopy(giveUpMessage);
        char expected = '\u0000';

        assertEquals(expected, emptyChar);
    }

    @Test
    void testThatUserDontGaveUpReturnFalse() {
        String shortInput = "a";
        Character emptyChar = inputLetterCopy(shortInput);
        char expected = '\u0000';

        assertFalse(emptyChar.equals(expected));
    }


    private static char inputLetterCopy(String string) {
        String input = string;

        if (input.length() == 1) {
            return input.charAt(0);
        } else if (input.equalsIgnoreCase("white flag")) {
            GameState.endGame(false);
            return 0;
        } else {
            throw new IllegalArgumentException(
                "Вы ввели больше одного символа."
            );
        }
    }

}
