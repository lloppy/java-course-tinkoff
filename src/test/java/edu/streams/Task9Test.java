package edu.streams;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.SPIDER;
import static org.junit.jupiter.api.Assertions.*;

class Task9Test {

    @Test
    void testThatSumAllPawsReturnedExpectedSum() {
        Animal cat = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, bird, spider);

        Task9 task9 = new Task9(animals);

        int sumAllPaws = task9.getSumAllPaws();
        int expectedSum = 4 + 4 + 2 + 8;

        assertEquals(expectedSum, sumAllPaws);
    }
}
