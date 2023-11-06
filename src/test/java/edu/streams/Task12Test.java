package edu.streams;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task12Test {
    @Test
    void testThatWeightExceedsHeightAnimalsCount() {
        Animal animal1 = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 120, 200, true);
        Animal animal2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 3, 101, 150, true);
        Animal animal3 = new Animal("Parrot", Animal.Type.BIRD, Animal.Sex.F, 2, 20, 30, true);
        Animal animal4 = new Animal("Snake", Animal.Type.FISH, Animal.Sex.F, 5, 150, 15, true);
        Animal animal5 = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 10, 5, false);

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4, animal5);

        Task12 task12 = new Task12(animals);
        int count = task12.getWeightExceedsHeightAnimals();

        assertEquals(3, count);

    }

}
