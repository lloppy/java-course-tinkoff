package edu.hangman.ui;

import edu.hangman.words.Word;

public final class Messages {
    private Messages() {
    }

    public static void startGame(final String guessedWord) {
        int difference = Dimensions.half - guessedWord.length();

        printHeader();
        print("*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*");
        print("*\t \t Слово загадано! \t \t *");
        print("*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*");
        print("*" + " ".repeat(difference)
            + "_ ".repeat(guessedWord.length()) + " ".repeat(difference) + "*");
        print("*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*");
        print("*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*");
    }

    public static void printYouGuessedCorrectly(
        final Word word,
        final char letter
    ) {
        print("\n" + word.getHiddenString());
        print("*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*");
        print("*\t\tВы угадали букву " + letter + "! \t *");
        print("*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*");
    }

    public static void printYouDidNotGuess(final char letter) {
        print("*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*");
        print("*\t Вы не угадали букву " + letter + ". \t *");
        print("*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*");
    }

    public static void printGameWon() {
        printGameResult("  " + "Вы выиграли!" + "  ");
    }

    public static void printGameLost() {
        printGameResult(" " + "Вы проиграли!" + "  ");
    }

    public static String printLongInputWarning() {
        return "Вы ввели больше одного символа!";
    }
    public static void enterWord() {
        System.out.print(
            "\n" + " ".repeat(Dimensions.SIDE) + "Введите букву: "
        );
    }

    private static void printHeader() {
        String header = "~".repeat(Dimensions.SIDE);
        print("\n*" + header + Dimensions.gameName + header + "*");
    }



    private static void print(final String message) {
        System.out.println(message);
    }

    private static void printGameResult(final String result) {
        printHeader();
        print("*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*");
        print("*\t \t " + result + " \t\t *");
        print("*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*");
        print("*" + "~".repeat(Dimensions.lengthWhiteSpace) + "*");
    }
}
