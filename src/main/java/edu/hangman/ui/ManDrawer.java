package edu.hangman.ui;

public final class ManDrawer {
    private ManDrawer() {
    }

    public static final int STAGES = 5;

    private static final String[] HANGMAN_ATTEMPTS = {
        "  +---+\n      |\n      |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n========="
    };

    public static void drawHangman(final int attempts) {
        System.out.println(HANGMAN_ATTEMPTS[STAGES - attempts]);
    }

}
