package edu.hangman.game;

import edu.hangman.guess.LetterGuessFactory;
import edu.hangman.ui.Messages;
import edu.hangman.words.Word;
import java.util.Scanner;

public final class Game {
    private Game() {
    }

    public static void playGame(final String[] words) {
        Word word = new Word(words);
        LetterGuessFactory guessFactory = new LetterGuessFactory();

        while (GameState.isGameRunning()) {
            try {
                Character inputLetter = inputLetter();

                if (!inputLetter.equals('\u0000')) {
                    guessFactory.createLetterGuess(word, inputLetter);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static char inputLetter() {
        Messages.enterWord();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

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
