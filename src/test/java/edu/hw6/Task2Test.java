package edu.hw6;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import edu.hw6.task2.Task2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {


    @Test
    void testThatClonePathIncreaseCopyNumber() {
        String originalPath = "Tinkoff Bank Biggest Secret — копия (2).txt";
        Path path = Paths.get(originalPath);

        try {
            assertEquals(
                "Tinkoff Bank Biggest Secret — копия (3).txt",
                Task2.cloneFile(path).toString()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThatClonePathAddCopyNumber() {
        String originalPath = "Tinkoff Bank Biggest Secret — копия.txt";
        Path path = Paths.get(originalPath);

        try {
            assertEquals(
                "Tinkoff Bank Biggest Secret — копия (2).txt",
                Task2.cloneFile(path).toString()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThatClonePathAddCopySuffix() {
        String originalPath = "Tinkoff Bank Biggest Secret.txt";
        Path path = Paths.get(originalPath);

        try {
            assertEquals(
                "Tinkoff Bank Biggest Secret — копия.txt",
                Task2.cloneFile(path).toString()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThatClonePathIncreaseTwoDigitNumberToThreeDigit() {
        String originalPath = "Tinkoff Bank Biggest Secret — копия (99).txt";
        Path path = Paths.get(originalPath);

        try {
            assertEquals(
                "Tinkoff Bank Biggest Secret — копия (100).txt",
                Task2.cloneFile(path).toString()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
