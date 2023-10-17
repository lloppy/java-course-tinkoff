package edu.hangman.guess;

import edu.hangman.words.Word;

public interface LetterGuess {

    void handleGuessedLetter(Word word, char letter);

    void handleNotGuessedLetter(char letter);
}
