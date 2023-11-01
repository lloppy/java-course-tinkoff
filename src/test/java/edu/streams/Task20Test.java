package edu.streams;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task20Test {

    @Test
    void testFindTheLargestAnimalsOfEachType() {
        Animal cat1 = new Animal("kitti", CAT, M, 5, 30, 12, false);
        Animal cat2 = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("r1", DOG, M, 6, 50, 20, true);
        List<Animal> animals = List.of(cat1, cat2, dog);

        Task20 task20 = new Task20(animals);
        Map<String, String> errorAnimals = task20
            .getValidationErrorAnimals();

        assertEquals("", errorAnimals.get(cat2.name()));
        assertEquals("", errorAnimals.get(cat1.name()));
        assertEquals(
            "короткое имя, имя содержит цифры",
            errorAnimals.get(dog.name())
        );
    }
}
