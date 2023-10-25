package edu.hangman.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HangmanGameTest {

    @Test
    void testThatGameIsStartReturnedTrue() {
        HangmanGame.main(new String[] {"arg1", "arg2"});

        assertTrue(GameState.isGameRunning() == true);

    }

}
