package edu.streams;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.SPIDER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task17Test {
    Task17 task;

    @Test
    void testIsSpidersBiteOftenDogsWhenNoData() {
        List<Animal> animals = new ArrayList<>();
        task = new Task17(animals);
        assertFalse(task.isSpidersBiteOftenDogs());
    }

    @Test
    void testIsSpidersBiteOftenDogsWhenMoreSpiders() {
        List<Animal> animals = new ArrayList<>();
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, true);
        Animal spider2 = new Animal("spiky", SPIDER, M, 1, 3, 1, true);

        animals.add(spider);
        animals.add(spider2);
        animals.add(dog);

        task = new Task17(animals);
        assertTrue(task.isSpidersBiteOftenDogs());
    }

    @Test
    void testIsDogBiteOftenSpidersWhenMoreSpidersNoBite() {
        List<Animal> animals = new ArrayList<>();
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, false);
        Animal spider2 = new Animal("spi", SPIDER, M, 1, 3, 1, false);

        animals.add(spider);
        animals.add(spider2);
        animals.add(dog);

        task = new Task17(animals);
        assertFalse(task.isSpidersBiteOftenDogs());
    }

    @Test
    void testIsSpidersBiteOftenDogsWhenMoreDogs() {
        List<Animal> animals = new ArrayList<>();
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal dog2 = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, true);

        animals.add(spider);
        animals.add(dog2);
        animals.add(dog);

        task = new Task17(animals);
        assertFalse(task.isSpidersBiteOftenDogs());
    }

    @Test
    void testIsSpidersBiteOftenDogsWhenEqualCounts() {
        List<Animal> animals = new ArrayList<>();

        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, true);

        animals.add(spider);
        animals.add(dog);

        task = new Task17(animals);
        assertFalse(task.isSpidersBiteOftenDogs());
    }


    @Test
    void testIsSpidersBiteOftenDogsWhenOtherAnimalsExist() {
        Animal cat = new Animal("katti", CAT, F, 4, 28, 11, true);
        Animal cat2 = new Animal("katti", CAT, F, 4, 28, 11, true);
        Animal cat3 = new Animal("katti", CAT, F, 4, 28, 11, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal dog2 = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, true);

        List<Animal> animals = List.of(cat, dog, bird, spider, dog2, cat2, cat3);

        task = new Task17(animals);
        assertFalse(task.isSpidersBiteOftenDogs());
    }

}
