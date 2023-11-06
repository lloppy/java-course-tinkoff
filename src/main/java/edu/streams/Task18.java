package edu.streams;

import edu.streams.util.ListAnimalSorter;
import java.util.Comparator;
import java.util.List;
import static edu.streams.Animal.Type.FISH;

/**
 * Задача 18.
 * Найти самую тяжелую рыбку в 2-х или более списках -> Animal
 */
public final class Task18 extends ListAnimalSorter {
    private Animal heaviestFish;

    public Task18(final List<List<Animal>> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        heaviestFish = animals.stream()
            .flatMap(List::stream)
            .filter(animal -> (animal.type() == FISH))
            .max(Comparator.comparingInt(o -> o.weight()))
            .orElse(null);
    }

    public Animal getHeaviestFish() {
        return heaviestFish;
    }
}
