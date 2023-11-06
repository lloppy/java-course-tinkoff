package edu.streams;

import edu.streams.Animal.Type;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.BIRD;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.SPIDER;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6Test {

    @Test
    void testFindTheLargestAnimalsOfEachType() {
        Animal cat1 = new Animal("kitti", CAT, M, 5, 30, 12, false);
        Animal cat2 = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider1 = new Animal("spi", SPIDER, M, 1, 3, 1, false);
        Animal spider2 = new Animal("spi", SPIDER, M, 1, 3, 100, false);

        List<Animal> animals = List.of(cat1, cat2, dog, bird, spider1, spider2);

        Task6 task6 = new Task6(animals);
        Map<Type, Animal> largestAnimals = task6.getTheLargestAnimals();

        assertEquals(cat1, largestAnimals.get(CAT));
        assertEquals(dog, largestAnimals.get(DOG));
        assertEquals(bird, largestAnimals.get(BIRD));
        assertEquals(spider2, largestAnimals.get(SPIDER));
    }

}
