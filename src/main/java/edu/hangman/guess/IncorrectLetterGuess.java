package edu.hangman.guess;

import edu.hangman.game.GameState;
import edu.hangman.ui.Messages;
import edu.hangman.words.Word;
import edu.hangman.ui.ManDrawer;

public class IncorrectLetterGuess implements LetterGuess {
    private static int attempts = ManDrawer.STAGES;
    public IncorrectLetterGuess() {
    }

    @Override
    public final LetterGuess handleGuessedLetter(final Word word, final char letter) {
        return null;
    }

    @Override
    public final LetterGuess handleNotGuessedLetter(final char letter) {
        ManDrawer.drawHangman(attempts);
        decreaseAttempts();
        Messages.printYouDidNotGuess(letter);

        if (attempts == 0) {
            GameState.endGame(false);
        }
        return null;
    }

    public static final void decreaseAttempts() {
        --attempts;
    }

}
