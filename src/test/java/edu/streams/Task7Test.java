package edu.streams;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.SPIDER;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task7Test {

    @Test
    void oldestAnimal() {
        Animal cat = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, bird, spider);

        Task7 task7 = new Task7(animals);

        assertEquals(dog, task7.getTheOldestAnimal());
    }


}
