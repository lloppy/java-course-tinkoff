package edu.hangman.game;

import edu.hangman.guess.CorrectLetterGuess;
import edu.hangman.guess.IncorrectLetterGuess;
import edu.hangman.guess.LetterGuess;
import edu.hangman.words.Word;
import java.util.Scanner;

public final class Game {
    private Game() {
    }

    public static void playGame(final String[] words) {
        Word word = new Word(words);
        LetterGuess letterGuess;

        while (GameState.isGameRunning()) {
            char inputLetter = inputLetter();

            if (word.isCharInWord(inputLetter)) {
                letterGuess = new CorrectLetterGuess();
                letterGuess.handleGuessedLetter(word, inputLetter);
            } else {
                letterGuess = new IncorrectLetterGuess();
                letterGuess.handleNotGuessedLetter(inputLetter);
            }

        }

    }

    private static char inputLetter() {
        System.out.println("Введите букву");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() == 1) {
            return input.charAt(0);
        } else {
            System.out.println(
                "Вы ввели больше одного символа. Введите снова."
            );
            return inputLetter();
        }
    }
}
