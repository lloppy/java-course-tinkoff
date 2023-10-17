package edu.hangman.guess;

import edu.hangman.game.GameState;
import edu.hangman.words.Word;

public class CorrectLetterGuess implements LetterGuess {

    public CorrectLetterGuess() {
    }

    @Override
    public final void handleGuessedLetter(final Word word, final char letter) {
        System.out.println("Вы угадали букву " + letter + "!");

        if (word.isSolved()) {
            GameState.endGame(true);
        }
    }

    @Override
    public void handleNotGuessedLetter(final char letter) {
    }
}
