package edu.hangman.game;

public class GameState {
    private static boolean isGameRunning;
    private static boolean isGameWon;
    private static String[] words = {"Java", "Class", "Android"};

    public GameState() {
        isGameRunning = true;
        isGameWon = false;
    }

    public static boolean isGameRunning() {
        return isGameRunning;
    }

    public static void endGame(boolean isGameWon) {
        isGameRunning = false;
        GameState.isGameWon = isGameWon;
        System.out.println(isGameWon ? "Вы выиграли!" : "Вы проиграли!");
    }
}
