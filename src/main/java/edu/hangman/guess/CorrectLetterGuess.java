package edu.hangman.guess;

import edu.hangman.game.GameState;
import edu.hangman.ui.Messages;
import edu.hangman.words.Word;

public class CorrectLetterGuess implements LetterGuess {

    public CorrectLetterGuess() {
    }

    @Override
    public final LetterGuess handleGuessedLetter(final Word word, final char letter) {
        Messages.printYouGuessedCorrectly(word, letter);

        if (word.isSolved()) {
            GameState.endGame(true);
        }
        return null;
    }

    @Override
    public LetterGuess handleNotGuessedLetter(final char letter) {
        return null;
    }
}
