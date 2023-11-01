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

class Task10Test {

    @Test
    void testAgeNotMatchPawsAnimals() {
        Animal cat = new Animal("katti", CAT, F, 5, 28, 11, false);
        Animal dog = new Animal("rex", DOG, M, 4, 50, 20, true);
        Animal bird = new Animal("twix", BIRD, F, 2, 5, 1, false);
        Animal spider = new Animal("spi", SPIDER, M, 8, 3, 1, false);
        Animal fish = new Animal("nemo", FISH, M, 2, 0, 1, false);

        List<Animal> animals = List.of(cat, dog, bird, spider, fish);

        Task10 task10 = new Task10(animals);

        List<Animal> ageNotMatchPawsAnimals = task10.getAgeNotMatchPawsAnimals();

        assertEquals(2, ageNotMatchPawsAnimals.size());
        assertEquals(cat, ageNotMatchPawsAnimals.get(0));
        assertEquals(fish, ageNotMatchPawsAnimals.get(1));
    }
}
