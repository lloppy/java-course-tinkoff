package edu.hangman.ui;

import edu.hangman.words.Word;

public final class Messages {
    private Messages() {
    }

    public static void startGame(final String guessedWord) {
        int difference = Dimensions.SCREEN_HALF - guessedWord.length();

        printHeader();
        print("*" + " ".repeat(Dimensions.WHITE_SPACE) + "*");
        print("*\t \t Слово загадано! \t \t *");
        print("*" + " ".repeat(Dimensions.WHITE_SPACE) + "*");
        print("*" + " ".repeat(difference)
            + "_ ".repeat(guessedWord.length()) + " ".repeat(difference) + "*");
        print("*" + " ".repeat(Dimensions.WHITE_SPACE) + "*");
        print("*" + "-".repeat(Dimensions.WHITE_SPACE) + "*");
    }

    public static void printYouGuessedCorrectly(
        final Word word,
        final char letter
    ) {
        print(word.getHiddenString());
        print("*" + "-".repeat(Dimensions.WHITE_SPACE) + "*");
        print("*\t\tВы угадали букву " + letter + "! \t *");
        print("*" + "-".repeat(Dimensions.WHITE_SPACE) + "*");
    }

    public static void printYouDidNotGuess(final char letter) {
        print("*" + "-".repeat(Dimensions.WHITE_SPACE) + "*");
        print("* Не угадали. Буквы " + letter + " здесь нет! *");
        print("*" + "-".repeat(Dimensions.WHITE_SPACE) + "*");
    }

    public static void printGameWon() {
        printGameResult("  " + "Вы выиграли!" + "  ");
    }

    public static void printGameLost() {
        printGameResult(" " + "Вы проиграли!" + "  ");
    }

    public static String returnInputWarning() {
        return "Вы ввели больше одного символа!";
    }

    public static void printInputWarning(String message) {
        print(message);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void enterWord() {
        System.out.print(
            "\n" + " ".repeat(Dimensions.SIDE) + "Введите букву: "
        );
    }

    private static void printHeader() {
        String header = "~".repeat(Dimensions.SIDE);
        print("\n*" + header + Dimensions.GAME_NAME + header + "*");
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private static void print(final String message) {
        System.out.println(message);
    }

    private static void printGameResult(final String result) {
        printHeader();
        print("*" + " ".repeat(Dimensions.WHITE_SPACE) + "*");
        print("*\t \t " + result + " \t\t *");
        print("*" + " ".repeat(Dimensions.WHITE_SPACE) + "*");
        print("*" + "~".repeat(Dimensions.WHITE_SPACE) + "*");
    }
}
