package edu.hangman.guess;

import edu.hangman.game.GameState;
import edu.hangman.ui.HangmanDrawer;
import edu.hangman.ui.Messages;
import edu.hangman.words.Word;

public final class IncorrectLetterGuess implements LetterGuess {
    private static int attempts = HangmanDrawer.STAGES;

    public IncorrectLetterGuess() {
    }

    @Override
    public LetterGuess handleGuessedLetter(final Word word, final char letter) {
        return null;
    }

    @Override
    public LetterGuess handleNotGuessedLetter(final char letter) {
        HangmanDrawer.drawHangman(attempts);
        decreaseAttempts();
        Messages.printYouDidNotGuess(letter);

        if (attempts == 0) {
            GameState.endGame(false);
        }
        return null;
    }

    private static void decreaseAttempts() {
        --attempts;
    }

}
