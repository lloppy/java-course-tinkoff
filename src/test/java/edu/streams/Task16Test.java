package edu.streams;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.FISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task16Test {

    @Test
    public void testThatSortAnimalsReturnsAnimalsSortedByType() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", CAT, M, 3, 25, 5, false),
            new Animal("Dog", DOG, F, 4, 30, 6, true),
            new Animal("Bird", BIRD, F, 2, 10, 1, false),
            new Animal("Fish", FISH, M, 1, 5, 0, false)
        );

        Task16 task = new Task16(animals);

        List<Animal> sortedAnimals = task.getSortedAnimals();

        //   in Animal class:     CAT, DOG, BIRD, FISH, SPIDER
        List<Animal> expectedSortedAnimals = Arrays.asList(
            new Animal("Cat", CAT, M, 3, 25, 5, false),
            new Animal("Dog", DOG, F, 4, 30, 6, true),
            new Animal("Bird", BIRD, F, 2, 10, 1, false),
            new Animal("Fish", FISH, M, 1, 5, 0, false)
        );

        assertEquals(expectedSortedAnimals, sortedAnimals);
    }

    @Test
    public void testThatSortAnimalsReturnsAnimalsSortedBySex() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", CAT, M, 3, 25, 5, false),
            new Animal("Dog", DOG, F, 4, 30, 6, true),
            new Animal("Cat2", CAT, F, 2, 10, 1, false),
            new Animal("Dog2", DOG, M, 1, 5, 0, false)
        );

        Task16 task = new Task16(animals);

        List<Animal> sortedAnimals = task.getSortedAnimals();

        //   in Animal class:     CAT, DOG, BIRD, FISH, SPIDER
        //   in Animal class:     M, F
        List<Animal> expectedSortedAnimals = Arrays.asList(
            new Animal("Cat", CAT, M, 3, 25, 5, false),
            new Animal("Cat2", CAT, F, 2, 10, 1, false),
            new Animal("Dog2", DOG, M, 1, 5, 0, false),
            new Animal("Dog", DOG, F, 4, 30, 6, true)
        );

        assertEquals(expectedSortedAnimals, sortedAnimals);
    }

    @Test
    public void testThatSortAnimalsReturnsAnimalsSortedByName() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", CAT, M, 3, 25, 5, false),
            new Animal("Zog", DOG, F, 4, 30, 6, true),
            new Animal("Zat2", CAT, F, 2, 10, 1, false),
            new Animal("Dog", DOG, F, 4, 30, 6, true),
            new Animal("Cat2", CAT, F, 2, 10, 1, false),
            new Animal("Dog2", DOG, M, 1, 5, 0, false)
        );

        Task16 task = new Task16(animals);

        List<Animal> sortedAnimals = task.getSortedAnimals();

        //   in Animal class:     CAT, DOG, BIRD, FISH, SPIDER
        //   in Animal class:     M, F
        List<Animal> expectedSortedAnimals = Arrays.asList(
            new Animal("Cat", CAT, M, 3, 25, 5, false),
            new Animal("Cat2", CAT, F, 2, 10, 1, false),
            new Animal("Zat2", CAT, F, 2, 10, 1, false),
            new Animal("Dog2", DOG, M, 1, 5, 0, false),
            new Animal("Dog", DOG, F, 4, 30, 6, true),
            new Animal("Zog", DOG, F, 4, 30, 6, true)
        );

        assertEquals(expectedSortedAnimals, sortedAnimals);
    }
}
