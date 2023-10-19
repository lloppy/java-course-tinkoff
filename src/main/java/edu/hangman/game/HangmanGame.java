package edu.hangman.game;

import edu.hangman.ui.Messages;

public final class HangmanGame {
    private HangmanGame() {
    }

    private static String[] words = {"Java", "Class", "Android"};

    /**
     * Start point of the Hangman game.
     *
     * @param args no use
     */
    public static void main(final String[] args) {
        Messages messages = new Messages();
        GameState gameState = new GameState();
        Game.playGame(words);
    }
}
