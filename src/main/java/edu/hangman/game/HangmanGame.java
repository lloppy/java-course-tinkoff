package edu.hangman.game;

public final class HangmanGame {
    private HangmanGame() {
    }
    private static String[] words = {"Java", "Class", "Android"};

    public static void main(final String[] args) {
        GameState gameState = new GameState();
        Game.playGame(words);
    }

}
