package edu.streams;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task14Test {

    @Test
    void testGetDogExistWithTallDog() {
        Animal dog1 = new Animal("Dog1", DOG, M, 5, 60, 25, false);
        Animal dog2 = new Animal("Dog2", DOG, F, 3, 50, 30, false);
        Animal cat1 = new Animal("Cat1", CAT, F, 2, 25, 10, false);
        Animal bird1 = new Animal("Bird1", BIRD, M, 1, 15, 5, false);

        List<Animal> animals = List.of(dog1, dog2, cat1, bird1);

        int lowerBoundOfHeight = 50;

        Task14 task14 = new Task14(animals, lowerBoundOfHeight);
        Boolean dogExist = task14.getDogExist();

        assertTrue(dogExist);
    }

    @Test
    void testGetDogExistWithShortDog() {
        Animal dog1 = new Animal("Dog1", DOG, M, 5, 40, 25, false);
        Animal dog2 = new Animal("Dog2", DOG, F, 3, 50, 30, false);
        Animal cat1 = new Animal("Cat1", CAT, F, 2, 25, 10, false);
        Animal bird1 = new Animal("Bird1", BIRD, M, 1, 15, 5, false);

        List<Animal> animals = List.of(dog1, dog2, cat1, bird1);

        int lowerBoundOfHeight = 50;

        Task14 task14 = new Task14(animals, lowerBoundOfHeight);
        Boolean dogExist = task14.getDogExist();

        assertFalse(dogExist);
    }
}
