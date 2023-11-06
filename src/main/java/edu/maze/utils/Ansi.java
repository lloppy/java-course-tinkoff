package edu.maze.utils;

public final class Ansi {
    private Ansi() {
    }

    private static final String EMPTY_STRING = "   ";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[40m";
    private static final String ANSI_WHITE = "\u001B[47m";
    private static final String ANSI_GREEN = "\u001B[42m";
    private static final String ANSI_RED = "\u001B[41m";

    public static final String EMPTY_BLOCK =
        ANSI_WHITE + EMPTY_STRING + ANSI_RESET;
    public static final String RED_BLOCK =
        ANSI_RED + EMPTY_STRING + ANSI_RESET;
    public static final String WHITE_BLOCK =
        ANSI_WHITE + EMPTY_STRING + ANSI_RESET;
    public static final String GREEN_BLOCK =
        ANSI_GREEN + EMPTY_STRING + ANSI_RESET;
    public static final String BLACK_BLOCK =
        ANSI_BLACK + EMPTY_STRING + ANSI_RESET;

}
