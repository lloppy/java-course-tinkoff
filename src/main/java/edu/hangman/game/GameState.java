package edu.hangman.game;

import edu.hangman.ui.Messages;

public final class GameState {
    private GameState() {
    }

    private static boolean isGameRunning = true;
    private static boolean isGameWon = false;

    public static boolean isGameRunning() {
        return isGameRunning;
    }

    public static void endGame(final boolean gameWon) {
        isGameRunning = false;
        GameState.isGameWon = gameWon;

        if (isGameWon) {
            Messages.printGameWon();
        } else {
            Messages.printGameLost();
        }
    }
}
