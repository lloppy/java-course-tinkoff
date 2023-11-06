package edu.streams;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.FISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task18Test {

    @Test
    public void testThatGetHeaviestFishReturnsHeaviestFishFromMultipleLists() {
        List<Animal> fishList1 = List.of(
            new Animal("Fish1", FISH, Animal.Sex.M, 2, 10, 100, false),
            new Animal("Fish2", FISH, Animal.Sex.F, 3, 9, 120, false)
        );

        List<Animal> fishList2 = List.of(
            new Animal("Fish3", FISH, Animal.Sex.M, 4, 11, 95, false),
            new Animal("Dog", DOG, Animal.Sex.M, 4, 11, 400, false),
            new Animal("Fish4", FISH, Animal.Sex.F, 2, 8, 110, false)
        );

        List<List<Animal> > allFishLists = List.of(fishList1, fishList2);

        Task18 task18 = new Task18(allFishLists);
        Animal heaviestFish = task18.getHeaviestFish();

        assertEquals("Fish2", heaviestFish.name());
    }

    @Test
    public void testThatGetHeaviestFishReturnsNullWithEmptyLists() {
        List<List<Animal> > emptyLists = List.of();
        Task18 task18 = new Task18(emptyLists);
        Animal heaviestFish = task18.getHeaviestFish();

        // Проверяем, что результат равен null, когда список пустой
        assertEquals(null, heaviestFish);
    }
    @Test
    public void testThatGetHeaviestFishReturnsHeaviestFishWithThreeArrays() {
        List<Animal> fishList1 = List.of(
            new Animal("Fish1", FISH, Animal.Sex.M, 2, 10, 100, false),
            new Animal("Fish2", FISH, Animal.Sex.F, 3, 9, 120, false)
        );

        List<Animal> animalList = List.of(
            new Animal("Fish3", FISH, Animal.Sex.M, 4, 11, 95, false),
            new Animal("Dog", DOG, Animal.Sex.M, 4, 11, 400, false),
            new Animal("Fish4", FISH, Animal.Sex.F, 2, 8, 110, false)
        );

        List<Animal> fishList2 = List.of(
            new Animal("Fish5", FISH, Animal.Sex.M, 4, 11, 500, false),
            new Animal("Fish6", FISH, Animal.Sex.F, 2, 8, 110, false)
        );

        List<List<Animal> > allFishLists = List.of(fishList1, fishList2, animalList);

        Task18 task18 = new Task18(allFishLists);
        Animal heaviestFish = task18.getHeaviestFish();

        assertEquals("Fish5", heaviestFish.name());
    }
}
