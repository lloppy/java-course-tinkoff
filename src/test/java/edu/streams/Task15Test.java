package edu.streams;

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

class Task15Test {

    @Test
    void testSumWeighInBounds() {
        Animal cat = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 20, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, false);

        List<Animal> animals = List.of(cat, dog, bird, spider);

        Task15 task = new Task15(animals, 3, 6);
        Map<Animal.Type, Integer> result = task.getSumWeighInBounds();

        assertEquals(11, result.get(CAT));
        assertEquals(20, result.get(DOG));
        assertEquals(null, result.get(BIRD));
        assertEquals(null, result.get(SPIDER));
    }

    @Test
    void testSumWeighInBoundsSum() {
        Animal cat = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal kitti = new Animal("kitti", CAT, F, 4, 28, 6, false);
        Animal oldCat = new Animal("kot", CAT, F, 9, 28, 6, false);
        Animal dog = new Animal("rex", DOG, M, 6, 50, 19, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider = new Animal("spi", SPIDER, M, 1, 3, 1, false);

        List<Animal> animals = List.of(cat, kitti, dog, oldCat);

        Task15 task = new Task15(animals, 3, 6);
        Map<Animal.Type, Integer> result = task.getSumWeighInBounds();

        assertEquals(cat.weight() + kitti.weight(), result.get(CAT));
        assertEquals(19, result.get(DOG));

    }
}
