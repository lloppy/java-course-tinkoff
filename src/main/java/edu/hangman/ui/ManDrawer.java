package edu.hangman.ui;

public final class ManDrawer {
    private ManDrawer() {
    }

    public static final int STAGES = 5;

    private static final String[] HANGMAN_ATTEMPTS = {
        "\t\t\t  +---+\n\t\t\t      |\n\t\t\t      |\n\t\t\t      |\n\t\t\t      |\n\t\t\t      |\n\t\t\t=========",
        "\t\t\t  +---+\n\t\t\t  |   |\n\t\t\t      |\n\t\t\t      |\n\t\t\t      |\n\t\t\t      |\n\t\t\t=========",
        "\t\t\t  +---+\n\t\t\t  |   |\n\t\t\t  O   |\n\t\t\t      |\n\t\t\t      |\n\t\t\t      |\n\t\t\t=========",
        "\t\t\t  +---+\n\t\t\t  |   |\n\t\t\t  O   |\n\t\t\t /|   |\n\t\t\t      |\n\t\t\t      |\n\t\t\t=========",
        "\t\t\t  +---+\n\t\t\t  |   |\n\t\t\t  O   |\n\t\t\t /|\\  |\n\t\t\t      |\n\t\t\t      |\n\t\t\t========="
    };

    public static void drawHangman(final int attempts) {
        System.out.println(HANGMAN_ATTEMPTS[STAGES - attempts]);
    }

}
