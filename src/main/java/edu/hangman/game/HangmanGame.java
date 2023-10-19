package edu.hangman.game;

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
        // Start game.
        Game.playGame(words);
    }
}
