package edu.hangman.game;

public final class GameState {
    private static boolean isGameRunning;
    private static boolean isGameWon;

    public GameState() {
        isGameRunning = true;
        isGameWon = false;
    }

    public static boolean isGameRunning() {
        return isGameRunning;
    }

    public static void endGame(final boolean gameWon) {
        isGameRunning = false;
        GameState.isGameWon = gameWon;
        System.out.println(isGameWon ? "Вы выиграли!" : "Вы проиграли!");
    }
}
