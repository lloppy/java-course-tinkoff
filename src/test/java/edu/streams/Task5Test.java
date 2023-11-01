package edu.streams;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.FISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {

    @Test
    void testThatNumerousSexAnimalsReturnedIsMale() {
        Animal male1 = new Animal("Male1", CAT, M, 4, 10, 5, false);
        Animal female1 = new Animal("Female1", DOG, F, 3, 8, 4, false);
        Animal male2 = new Animal("Male2", FISH, M, 2, 6, 3, false);
        Animal female2 = new Animal("Female2", BIRD, F, 1, 4, 2, false);
        Animal male3 = new Animal("Male3", CAT, M, 4, 10, 5, false);
        List<Animal> animals = List.of(male1, female1, male2, female2, male3);

        Task5 task5 = new Task5(animals);

        assertEquals(M, task5.getNumerousSexAnimals());
    }

    @Test
    void testThatNumerousSexAnimalsReturnedIsFemale() {
        Animal male1 = new Animal("Male1", CAT, M, 4, 10, 5, false);
        Animal female1 = new Animal("Female1", DOG, F, 3, 8, 4, false);
        Animal female2 = new Animal("Female2", BIRD, F, 1, 4, 2, false);
        List<Animal> animals = List.of(male1, female1, female2);

        Task5 task5 = new Task5(animals);

        assertEquals(F, task5.getNumerousSexAnimals());
    }

    @Test
    void testThatNumerousSexAnimalsReturnedEquals() {
        Animal male1 = new Animal("Male1", CAT, M, 4, 10, 5, false);
        Animal female1 = new Animal("Female1", DOG, F, 3, 8, 4, false);
        List<Animal> animals = List.of(male1, female1);

        Task5 task5 = new Task5(animals);

        assertEquals(null, task5.getNumerousSexAnimals());
    }

    @Test
    void testThatNumerousSexAnimalsReturnedEqualns() {
        Animal male1 = new Animal("Male1", CAT, M, 4, 10, 5, false);
        Animal female1 = new Animal("Female1", DOG, F, 3, 8, 4, false);
        List<Animal> animals = List.of(male1, female1);

        Task5 task5 = new Task5(animals);

        assertEquals(null, task5.getNumerousSexAnimals());
    }

    @Test
    void testThatNumerousSexAnimalsReturnedMale() {
        Animal male1 = new Animal("Male1", CAT, M, 4, 10, 5, false);
        List<Animal> animals = List.of(male1);

        Task5 task5 = new Task5(animals);

        assertEquals(M, task5.getNumerousSexAnimals());
    }

    @Test
    void testThatNumerousSexAnimalsReturnedFemale() {
        Animal female1 = new Animal("Female1", DOG, F, 3, 8, 4, false);
        List<Animal> animals = List.of(female1);

        Task5 task5 = new Task5(animals);

        assertEquals(F, task5.getNumerousSexAnimals());
    }

}
