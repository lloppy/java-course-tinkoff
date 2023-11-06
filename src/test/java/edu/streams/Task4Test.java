package edu.streams;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.FISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {

    @Test
    void testThatAnimalWithLongestNameReturnedKitti() {
        Animal kitti = new Animal("kitti", CAT, F, 4, 26, 20, true);
        Animal bard = new Animal("bard", DOG, M, 4, 40, 30, true);
        Animal fish = new Animal("nemo", FISH, M, 4, 10, 2, false);

        List<Animal> animals = List.of(kitti, bard, fish);

        Task4 task4 = new Task4(animals);
        Animal animalWithLongestName = task4.getAnimalWithLongestName();

        assertEquals("kitti", animalWithLongestName.name());
    }

    @Test
    void testThatAnimalWithLongestNameReturnedRobert() {
        Animal kitti = new Animal("kitti", CAT, F, 4, 26, 20, true);
        Animal bard = new Animal("robert", DOG, M, 4, 40, 30, true);
        Animal fish = new Animal("nemo", FISH, M, 4, 10, 2, false);

        List<Animal> animals = List.of(kitti, bard, fish);

        Task4 task4 = new Task4(animals);
        Animal animalWithLongestName = task4.getAnimalWithLongestName();

        assertEquals("robert", animalWithLongestName.name());
    }

}
