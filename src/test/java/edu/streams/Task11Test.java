package edu.streams;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task11Test {

    // почему нет проверок на null?
    // ответ - https://sun9-5.userapi.com/impg/SwNPOBJT4NnZl1K3tG4KZY9oMky6_txOsz2oDA/Y8Y1pL_Hty4.jpg?size=836x391&quality=96&sign=d9958aee12c6e2729f5e3eb4ad223977&type=album
    @Test
    void testThatCanBiteAnimalsAndHigher100ReturnedExpected() {
        Animal animal1 = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 120, 200, true);
        Animal animal2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 3, 101, 150, true);
        Animal animal3 = new Animal("Parrot", Animal.Type.BIRD, Animal.Sex.F, 2, 20, 30, true);
        Animal animal4 = new Animal("Snake", Animal.Type.FISH, Animal.Sex.F, 5, 150, 15, true);
        Animal animal5 = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 10, 5, false);

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4, animal5);
        Task11 task11 = new Task11(animals);
        List<Animal> canBiteAnimals = task11.getCanBiteAnimalsHigher100();

        assertEquals(3, canBiteAnimals.size());

        assertTrue(canBiteAnimals.contains(animal1));
        assertTrue(canBiteAnimals.contains(animal2));
        assertTrue(canBiteAnimals.contains(animal4));

        assertFalse(canBiteAnimals.contains(animal3));
        assertFalse(canBiteAnimals.contains(animal5));

    }
}
