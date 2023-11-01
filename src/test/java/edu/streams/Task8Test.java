package edu.streams;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.SPIDER;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task8Test {

    @Test
    void oldestAnimal() {
        Animal cat = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, bird, spider);

        int edgeOfHeight = 51;
        Task8 task8 = new Task8(animals, edgeOfHeight);

        Optional<Animal> heaviestAnimal = task8.getTheOldestAnimal();

        assertEquals(dog, heaviestAnimal.get());
    }

    @Test
    void oldestAnimalcat() {
        Animal cat = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, bird, spider);

        int edgeOfHeight = 50;
        Task8 task8 = new Task8(animals, edgeOfHeight);

        Optional<Animal> heaviestAnimal = task8.getTheOldestAnimal();

        assertEquals(cat, heaviestAnimal.get());
    }

    @Test
    void oldestAnimalbird() {
        Animal cat = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, bird, spider);

        int edgeOfHeight = 10;
        Task8 task8 = new Task8(animals, edgeOfHeight);

        Optional<Animal> heaviestAnimal = task8.getTheOldestAnimal();

        assertEquals(bird, heaviestAnimal.get());
    }
}
