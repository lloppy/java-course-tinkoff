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

class Task1Test {

    @Test
    void testThatSortedReturnedExpectedOrder() {
        Animal cat = new Animal("mao", CAT, F, 4, 26, 20, true);
        Animal dog = new Animal("gou", DOG, M, 4, 40, 30, true);
        Animal fish = new Animal("nemo", FISH, M, 4, 10, 2, false);
        Animal bird = new Animal("niao", BIRD, F, 4, 5, 4, false);
        Animal spider = new Animal("miles", SPIDER, M, 4, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, fish, bird, spider);
        Task1 task1 = new Task1(animals);

        List<Animal> expectedSort = List.of(spider, bird, fish, cat, dog);

        for (int i = 0; i < animals.size(); i++) {
            assertEquals(expectedSort.get(i), task1.getSortedAnimals().get(i));
        }
    }

    @Test
    public void testThatSortEmptyListReturnedEmptyList() {
        List<Animal> animals = List.of();

        Task1 task1 = new Task1(animals);
        List<Animal> sortedAnimals = task1.getSortedAnimals();

        assertEquals(List.of(), sortedAnimals);
    }

    @Test
    public void testThatSortListWithOneElementReturnedSameElement() {
        Animal spider = new Animal("miles", SPIDER, M, 4, 3, 1, false);
        List<Animal> animals = List.of(spider);

        Task1 task1 = new Task1(animals);
        List<Animal> sortedAnimals = task1.getSortedAnimals();

        assertEquals(
            List.of(new Animal("miles", SPIDER, M, 4, 3, 1, false)),
            sortedAnimals
        );
    }

    @Test
    void testThatSorted2ReturnedExpectedOrder() {
        Animal morales = new Animal("miles", SPIDER, M, 16, 170, 65, false);
        Animal parker = new Animal("peter", SPIDER, M, 25, 180, 75, false);
        Animal osborn = new Animal("harry", SPIDER, M, 24, 175, 70, false);

        List<Animal> animals = List.of(morales, parker, osborn);
        Task1 task1 = new Task1(animals);

        List<Animal> expectedSort = List.of(morales, osborn, parker);

        for (int i = 0; i < animals.size(); i++) {
            assertEquals(expectedSort.get(i), task1.getSortedAnimals().get(i));
        }
    }
}
