package edu.hangman.guess;

import edu.hangman.game.GameState;
import edu.hangman.words.Word;

public class CorrectLetterGuess implements LetterGuess {
    private GameState gameState;

    public CorrectLetterGuess() {
        this.gameState = new GameState();
    };


    @Override
    public void handleGuessedLetter(Word word, char letter) {
        System.out.println("Вы угадали букву " + letter + "!");

        if (word.isSolved()) gameState.endGame(true);
    }

    @Override
    public void handleNotGuessedLetter(char letter) {
    }
}
