package edu.streams;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.FISH;
import static edu.streams.Animal.Type.SPIDER;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    @Test
    void testThatSorted2ReturnedExpectedOrder() {
        Animal morales = new Animal("miles", SPIDER, M, 16, 170, 65, false);
        Animal parker = new Animal("peter", SPIDER, M, 25, 180, 75, false);
        Animal osborn = new Animal("harry", SPIDER, M, 24, 175, 70, false);

        List<Animal> animals = List.of(morales, parker, osborn);
        int dropAfter = 2;
        Task2 task2 = new Task2(animals, dropAfter);

        List<Animal> expectedSort = List.of(osborn, parker);

        assertEquals(2, task2.getSortedAnimals().size());

    }

    @Test
    void testThatSortedReturnedExpectedOrder        () {
        Animal morales = new Animal("miles", SPIDER, M, 16, 170, 65, false);
        Animal parker = new Animal("peter", SPIDER, M, 25, 180, 75, false);
        Animal osborn = new Animal("harry", SPIDER, M, 24, 175, 70, false);

        List<Animal> animals = List.of(morales, parker, osborn);
        int dropAfter = 2;
        Task2 task2 = new Task2(animals, dropAfter);

        List<Animal> expectedSort = List.of(parker, osborn);

        for (int i = 0; i < expectedSort.size(); i++) {
            assertEquals(expectedSort.get(i), task2.getSortedAnimals().get(i));
        }
    }

    @Test
    void testSortAnimalsByWeightAndSelectTopK() {
        Animal cat = new Animal("mao", CAT, F, 4, 26, 20, true);
        Animal dog = new Animal("gou", DOG, M, 4, 40, 30, true);
        Animal fish = new Animal("nemo", FISH, M, 4, 10, 2, false);
        Animal bird = new Animal("niao", BIRD, F, 4, 5, 4, false);
        Animal spider = new Animal("miles", SPIDER, M, 4, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, fish, bird, spider);
        Task2 task2 = new Task2(animals, 3);

        List<Animal> sortedAnimals = task2.getSortedAnimals();
        List<Animal> expectedSort = List.of(dog, cat, bird);

        assertEquals(3, sortedAnimals.size());
        for (int i = 0; i < expectedSort.size(); i++) {
            assertEquals(expectedSort.get(i), sortedAnimals.get(i));
        }
    }

    @Test
    void testSortAnimalsByWeightAndSelectAll() {
        Animal cat = new Animal("mao", CAT, F, 4, 26, 20, true);
        Animal dog = new Animal("gou", DOG, M, 4, 40, 30, true);
        Animal fish = new Animal("nemo", FISH, M, 4, 10, 2, false);
        Animal bird = new Animal("niao", BIRD, F, 4, 5, 4, false);
        Animal spider = new Animal("miles", SPIDER, M, 4, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, fish, bird, spider);
        Task2 task2 = new Task2(animals, animals.size());
        List<Animal> sortedAnimals = task2.getSortedAnimals();

        List<Animal> expectedSort = List.of(dog, cat, bird, fish, spider);

        assertEquals(animals.size(), sortedAnimals.size());
        for (int i = 0; i < animals.size(); i++) {
            assertEquals(expectedSort.get(i), sortedAnimals.get(i));
        }
    }
}
