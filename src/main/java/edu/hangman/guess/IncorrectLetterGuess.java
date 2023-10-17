package edu.hangman.guess;

import edu.hangman.game.GameState;
import edu.hangman.words.Word;
import edu.hangman.ui.ManDrawer;

public class IncorrectLetterGuess implements LetterGuess {
    ManDrawer manDrawer = new ManDrawer();
    public int attempts = 5;

    private GameState gameState;

    public IncorrectLetterGuess() {
        this.gameState = new GameState();
    }

    ;

    @Override
    public void handleGuessedLetter(Word word, char letter) {
    }

    @Override
    public void handleNotGuessedLetter(char letter) {
        manDrawer.drawHangman(attempts);
        decreaseAttempts();
        System.out.println("Вы не угадали букву " + letter + ".");

        if (attempts == 0) {
            gameState.endGame(false);
        }
    }

    public void decreaseAttempts() {
        --attempts;
    }

}
