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
    @SuppressWarnings("uncommentedmain")
    public static void main(final String[] args) {
        Game.playGame(words);
    }
}
