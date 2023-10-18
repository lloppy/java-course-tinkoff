package edu.hangman.ui;

import edu.hangman.words.Word;

public final class Messages {
    public static void startGame(String guessedWord) {
        String header = "-".repeat(Dimensions.half - Dimensions.gameName.length() / 2);
        int difference = Dimensions.half - guessedWord.length();

        print(
            "\n*" + header + Dimensions.gameName + header + "*\n" +
                "*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*\n" +
                "*" + "\t \t " + "Слово загадано!" + "\t \t" + " *\n" +
                "*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*\n" +
                "*" + " ".repeat(difference) + "_ ".repeat(guessedWord.length()) + " ".repeat(difference) + "*\n" +
                "*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*\n" +
                "*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*"
        );
    }

    public static void printYouGuessedCorrectly(Word word, char letter) {
        print("\n" + word.getHiddenString());
        print(
            "\n*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*" + "\n" +

                "*\t\tВы угадали букву " + letter + "!" + " \t *\n" +
                "*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*"

        );
    }

    public static void printYouDidNotGuess(char letter) {
        print(
            "\n*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*" + "\n" +
                "*\t Вы не угадали букву " + letter + "." + " \t *\n" +
                "*" + "-".repeat(Dimensions.lengthWhiteSpace) + "*"

        );
    }

    public static void printGameWon() {
        String header = "~".repeat(Dimensions.half - Dimensions.gameName.length() / 2);

        print(
            "\n*" + header + Dimensions.gameName + header + "*\n" +
                "*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*\n" +
                "*" + "\t \t " + "  Вы выиграли! " + "\t\t" + " * \n" +
                "*" + " ".repeat(Dimensions.lengthWhiteSpace) + "*\n" +
                "*" + "~".repeat(Dimensions.lengthWhiteSpace) + "*"

        );
    }

    public static void printGameLost() {
        print(
            "\n\n" +
                "Вы проиграли!"
        );
    }

    public static void enterWord() {
        System.out.print("\n" + " ".repeat(9) + "Введите букву: ");

    }

    private static void print(String message) {
        System.out.println(message);
    }

}
