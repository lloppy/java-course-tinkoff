package edu.hangman.ui;

public final class ManDrawer {
    private ManDrawer() {
    }

    public static final int STAGES = 5;
    private static String TAB = "\n\t\t\t ";

    private static final String[] HANGMAN_ATTEMPTS = {
        TAB + " +---+" + TAB + "     |" + TAB + "     |" + TAB + "     |" + TAB + "     |" + TAB + "     |" + TAB +  "     |" + TAB + "=".repeat(10),
        TAB + " +---+" + TAB + " |   |" + TAB + "     |" + TAB + "     |" + TAB + "     |" + TAB + "     |" + TAB +  "     |" + TAB + "=".repeat(10),
        TAB + " +---+" + TAB + " |   |" + TAB + " O   |" + TAB + "     |" + TAB + "     |" + TAB + "     |" + TAB +  "     |" + TAB + "=".repeat(10),
        TAB + " +---+" + TAB + " |   |" + TAB + " O   |" + TAB + "/|\\  |" + TAB + "     |" + TAB + "     |" + TAB +  "     |" + TAB + "=".repeat(10),
        TAB + " +---+" + TAB + " |   |" + TAB + " O   |" + TAB + "/|\\  |" + TAB + " |   |" + TAB + "/ \\  |" + TAB +  "     |" + TAB + "=".repeat(10)
    };

    public static void drawHangman(final int attempts) {
        System.out.println(HANGMAN_ATTEMPTS[STAGES - attempts]);
    }

}
