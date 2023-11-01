package edu.streams;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.FISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3Test {

    @Test
    void test() {
        Animal cat = new Animal("mao", CAT, F, 4, 26, 20, true);
        Animal dog = new Animal("gou", DOG, M, 4, 40, 30, true);
        Animal fish = new Animal("nemo", FISH, M, 4, 10, 2, false);

        List<Animal> animals = List.of(cat, dog, fish);

        Task3 task3 = new Task3(animals);
        Map<Animal.Type, Integer> sortedAnimals = task3.getSortedAnimals();

        assertEquals(1, sortedAnimals.get(CAT));
        assertEquals(1, sortedAnimals.get(DOG));
        assertEquals(1, sortedAnimals.get(FISH));
    }

    @Test
    void testM() {
        Animal mao = new Animal("mao", CAT, F, 4, 26, 20, true);
        Animal kitti = new Animal("kitti", CAT, F, 4, 26, 20, true);
        Animal gou = new Animal("gou", DOG, M, 4, 40, 30, true);
        Animal bard = new Animal("bard", DOG, M, 4, 40, 30, true);
        Animal fish = new Animal("nemo", FISH, M, 4, 10, 2, false);

        List<Animal> animals = List.of(mao, kitti, bard, gou, fish);

        Task3 task3 = new Task3(animals);
        Map<Animal.Type, Integer> sortedAnimals = task3.getSortedAnimals();

        assertEquals(2, sortedAnimals.get(CAT));
        assertEquals(2, sortedAnimals.get(DOG));
        assertEquals(1, sortedAnimals.get(FISH));
    }
}
