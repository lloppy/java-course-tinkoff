package edu.hangman.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HangmanDrawerTest {
    public static final int STAGES = 5;
    private static final String FAKE_TAB = "\n\t\t\t";
    private static final String FAKE_DEFAULT = FAKE_TAB + "     |";
    private static final String FAKE_UPPER_LOG = FAKE_TAB + " +---+";
    private static final String FAKE_ROPE = FAKE_TAB + " |   |";
    private static final String FAKE_HEAD = FAKE_TAB + " O   |";
    private static final String FAKE_BODY = FAKE_TAB + "/|\\  |";
    private static final String FAKE_LEGS = FAKE_TAB + "/ \\  |";

    private static final String[] FAKE_HANGMAN_SCENES = {
        FAKE_UPPER_LOG + fakeEndOfString(6),
        FAKE_UPPER_LOG + FAKE_ROPE + fakeEndOfString(5),
        FAKE_UPPER_LOG + FAKE_ROPE + FAKE_HEAD + fakeEndOfString(4),
        FAKE_UPPER_LOG + FAKE_ROPE + FAKE_HEAD + FAKE_BODY + fakeEndOfString(3),
        FAKE_UPPER_LOG + FAKE_ROPE + FAKE_HEAD + FAKE_BODY + FAKE_ROPE + FAKE_LEGS + fakeEndOfString(1)
    };

    @Test
    void testThatEqualsGameStageReturnEqualsPictures() {
        int remainingAttempts = 1;
        String expectedPictureForLastAttempt = "\n" +
            "\t\t\t +---+\n" +
            "\t\t\t |   |\n" +
            "\t\t\t O   |\n" +
            "\t\t\t/|\\  |\n" +
            "\t\t\t |   |\n" +
            "\t\t\t/ \\  |\n" +
            "\t\t\t     |\n" +
            "\t\t\t==========";

        String actualPicture = FAKE_HANGMAN_SCENES[HangmanDrawer.STAGES - remainingAttempts];

        assertEquals(expectedPictureForLastAttempt, actualPicture);
    }

    @Test
    void testThatNonEqualsGameStageReturnDifferentPictures() {
        int remainingAttempts = 4; // FirstStage
        String expectedPictureForFirstStage = "\n" +
            "\t\t\t +---+\n" +
            "\t\t\t |   |\n" +
            "\t\t\t     |\n" +
            "\t\t\t     |\n" +
            "\t\t\t     |\n" +
            "\t\t\t     |\n" +
            "\t\t\t     |\n" +
            "\t\t\t==========";

        String expectedPictureForLastStage = "\n" + // LastStage
            "\t\t\t +---+\n" +
            "\t\t\t |   |\n" +
            "\t\t\t O   |\n" +
            "\t\t\t/|\\  |\n" +
            "\t\t\t |   |\n" +
            "\t\t\t/ \\  |\n" +
            "\t\t\t     |\n" +
            "\t\t\t==========";

        String actualPictureForFirstStage = FAKE_HANGMAN_SCENES[HangmanDrawer.STAGES - remainingAttempts];

        assertNotEquals(expectedPictureForLastStage, actualPictureForFirstStage);
    }

    private static String fakeEndOfString(final int repeater) {
        return FAKE_DEFAULT.repeat(repeater) + FAKE_TAB + "=".repeat(Dimensions.SIDE);
    }
}
