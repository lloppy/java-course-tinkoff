package edu.hangman.guess;

import edu.hangman.words.Word;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LetterGuessFactoryTest {
    private ByteArrayOutputStream outContent;
    private String[] words;

    @BeforeEach
    void setUp() {
        words = new String[] {"Java", "Class", "Android"};
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void testThatExistLetterUseCorrectLetterGuessFabric() {
        Word word = new Word(words);
        char inputLetter = 'a';

        LetterGuessFactory guessFactory = new LetterGuessFactory();
        guessFactory.createLetterGuess(word, inputLetter);

        String consoleOutput = outContent.toString();
        String expected = "Вы угадали букву";

        assertTrue(consoleOutput.contains(expected));
    }

    @Test
    void testThatExistLetterUseCorrectLetterGuessReturnNonExistString() {
        Word word = new Word(words);
        char inputLetter = 'a';

        LetterGuessFactory guessFactory = new LetterGuessFactory();
        guessFactory.createLetterGuess(word, inputLetter);

        String consoleOutput = outContent.toString();
        String expectedWrongString = "Вы угадали букву! Стоп, нет! Ничего вы не угадали!";

        assertFalse(consoleOutput.contains(expectedWrongString));
    }

    @Test
    void testThatNotExistLetterUseIncorrectLetterGuessFabric() {
        Word word = new Word(words);
        char inputLetter = 'z';

        LetterGuessFactory guessFactory = new LetterGuessFactory();
        guessFactory.createLetterGuess(word, inputLetter);

        String consoleOutput = outContent.toString();
        CharSequence expected = "Вы не угадали букву " + inputLetter + ".";

        assertTrue(consoleOutput.contains(expected));
    }

    @Test
    void testThatNonExistLetterUseIncorrectLetterGuessFabricReturnNonExistString() {
        Word word = new Word(words);
        char inputLetter = 'z';

        LetterGuessFactory guessFactory = new LetterGuessFactory();
        guessFactory.createLetterGuess(word, inputLetter);

        String consoleOutput = outContent.toString();
        CharSequence expectedWrongString = "Вы не угадали букву " + inputLetter
            + ". Вы вообще ничего не угадали, давайте вы закроете эту игру?";

        assertFalse(consoleOutput.contains(expectedWrongString));
    }
}
