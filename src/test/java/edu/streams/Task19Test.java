package edu.streams;

import edu.streams.util.task19.ValidationError;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Sex.F;
import static edu.streams.Animal.Sex.M;
import static edu.streams.Animal.Type.CAT;
import static edu.streams.Animal.Type.DOG;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task19Test {
    @Test
    void testThatFindTheLargestAnimalsOfEachTypeReturnedExpectedSize() {
        Animal cat1 = new Animal("kitti", CAT, M, 5, 30, 12, false);
        Animal cat2 = new Animal("katti", CAT, F, 4, 28, 11, false);
        Animal dog = new Animal("r1", DOG, M, 6, 50, 20, true);
          List<Animal> animals = List.of(cat1, cat2, dog);

        Task19 task19 = new Task19(animals);
        Map<String, Set<ValidationError>> errorAnimals = task19
            .getValidationErrorAnimals();

        assertEquals(2, errorAnimals.get(dog.name()).size());
        assertEquals(0, errorAnimals.get(cat2.name()).size());
        assertEquals(0, errorAnimals.get(cat1.name()).size());

    }

}
