package edu.hangman.guess;

import edu.hangman.words.Word;

public interface LetterGuess {

    LetterGuess handleGuessedLetter(Word word, char letter);

    LetterGuess handleNotGuessedLetter(char letter);
}
