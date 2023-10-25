package edu.hangman.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GameStateTest {

    @Test
    void testThatGameEndsWhenGameWon() {
        GameState.endGame(true);
        assertFalse(GameState.isGameRunning());
    }
}
