package edu.streams;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task13Test {

    @Test
    void testWeightExceedsHeightAnimalsCount() {
        String longName = "Christian Heinrich Clemens Paul Frank Peter Wolf Wilhelm Ernst Friedrich Franz";
        Animal animal1 = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 120, 200, true);
        Animal animal2 = new Animal(longName, Animal.Type.DOG, Animal.Sex.M, 3, 101, 150, true);
        Animal animal3 = new Animal("Parrot", Animal.Type.BIRD, Animal.Sex.F, 2, 20, 30, true);
        Animal animal4 = new Animal("Snake", Animal.Type.FISH, Animal.Sex.F, 5, 150, 15, true);
        Animal animal5 = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 10, 5, false);

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4, animal5);

        Task13 task13 = new Task13(animals);
        List<Animal> animalsWithLongName = task13.getAnimalsWithLongName();

        assertEquals(1, animalsWithLongName.size());
        assertEquals(longName, animalsWithLongName.get(0).name());

    }


}
