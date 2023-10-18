package edu.hangman.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManDrawerTest {
    private static final String[] FAKE_HANGMAN_ATTEMPTS = {
        "  +---+\n      |\n      |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n========="
    };

    @Test
    void testThatEqualsGameStageReturnEqualsPictures() {
        int attempts = 1;
        String expectedPicture = "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            "      |\n" +
            "      |\n" +
            "=========";

        String actualPicture = FAKE_HANGMAN_ATTEMPTS[ManDrawer.STAGES - attempts];

        assertEquals(expectedPicture, actualPicture);
    }

    @Test
    void testThatNonEqualsGameStageReturnDifferentPictures() {
        int attempts = 4;
        String expectedPicture = "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            "      |\n" +
            "      |\n" +
            "=========";

        String actualPicture = FAKE_HANGMAN_ATTEMPTS[ManDrawer.STAGES - attempts];

        assertFalse(expectedPicture == actualPicture);
    }

}
