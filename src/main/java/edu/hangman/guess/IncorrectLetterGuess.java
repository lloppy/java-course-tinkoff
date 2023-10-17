package edu.hangman.guess;

import edu.hangman.game.GameState;
import edu.hangman.words.Word;
import edu.hangman.ui.ManDrawer;

public class IncorrectLetterGuess implements LetterGuess {
    private static int attempts = ManDrawer.STAGES;
    public IncorrectLetterGuess() {
    }

    @Override
    public final void handleGuessedLetter(final Word word, final char letter) {
    }

    @Override
    public final void handleNotGuessedLetter(final char letter) {
        ManDrawer.drawHangman(attempts);
        decreaseAttempts();
        System.out.println("Вы не угадали букву " + letter + ".");

        if (attempts == 0) {
            GameState.endGame(false);
        }
    }

    public static final void decreaseAttempts() {
        --attempts;
    }

}
