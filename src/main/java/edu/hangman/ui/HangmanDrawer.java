package edu.hangman.ui;

public final class HangmanDrawer {
    private HangmanDrawer() {
    }

    public static final int STAGES = 5;

    private static final String TAB = "\n\t\t\t";
    private static final String DEFAULT = TAB + "     |";
    private static final String UPPER_LOG = TAB + " +---+";
    private static final String ROPE = TAB + " |   |";
    private static final String HEAD = TAB + " O   |";
    private static final String BODY = TAB + "/|\\  |";
    private static final String LEGS = TAB + "/ \\  |";

    private static final String[] HANGMAN_SCENES = {
        UPPER_LOG + endOfString(6),
        UPPER_LOG + ROPE + endOfString(5),
        UPPER_LOG + ROPE + HEAD + endOfString(4),
        UPPER_LOG + ROPE + HEAD + BODY + endOfString(3),
        UPPER_LOG + ROPE + HEAD + BODY + ROPE + LEGS + endOfString(1)
    };

    private static String endOfString(final int repeater) {
        return DEFAULT.repeat(repeater) + TAB + "=".repeat(Dimensions.SIDE);

    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void drawHangman(final int attempts) {
        System.out.println(HANGMAN_SCENES[STAGES - attempts]);
    }
}
