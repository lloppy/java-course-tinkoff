package edu.hangman.repository.data;

public interface GameDatabase {
    String[] getWordsDatabase();

    String getRandomWord();
}
