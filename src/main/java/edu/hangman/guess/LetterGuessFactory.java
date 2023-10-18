package edu.hangman.guess;

import edu.hangman.words.Word;

public class LetterGuessFactory {
    public final LetterGuess createLetterGuess(
        final Word word,
        final char inputLetter
    ) {
        if (word.isCharInWord(inputLetter)) {
            LetterGuess letterGuess = new CorrectLetterGuess();
            return letterGuess.handleGuessedLetter(word, inputLetter);
        } else {
            LetterGuess letterGuess = new IncorrectLetterGuess();
            return letterGuess.handleNotGuessedLetter(inputLetter);
        }
    }
}
