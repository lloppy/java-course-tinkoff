package edu.hangman.game;

import edu.hangman.guess.CorrectLetterGuess;
import edu.hangman.guess.IncorrectLetterGuess;
import edu.hangman.guess.LetterGuess;
import edu.hangman.words.Word;
import java.util.Scanner;

public class Game {
    GameState gameState;
    private String[] words = {"Java", "Class", "Android"};

    private Word word;
    private LetterGuess letterGuess;

    public Game() {
        this.gameState = new GameState();
        this.word = new Word(words);

        playGame();
    }

    public void playGame() {
        while (gameState.isGameRunning()) {
            gameState.isGameRunning();
            char inputLetter = inputLetter();

            if (word.isCharInWord(inputLetter)) {
                letterGuess = new CorrectLetterGuess();
                letterGuess.handleGuessedLetter(word, inputLetter);
            } else {
                letterGuess = new IncorrectLetterGuess();
                letterGuess.handleNotGuessedLetter(inputLetter);
            }

        }

    }

    private static char inputLetter() {
        System.out.println("Введите одну букву");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() == 1) {
            return input.charAt(0);
        } else {
            System.out.println("Вы ввели более одного символа. Пожалуйста, попробуйте снова.");
            return inputLetter();
        }
    }
}
