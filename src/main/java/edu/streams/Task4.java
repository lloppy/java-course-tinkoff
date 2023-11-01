package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.Comparator;
import java.util.List;

/**
 * Задача 4.
 * У какого животного самое длинное имя -> Animal
 */
public final class Task4 extends AnimalSorter {
    private Animal theLongestName;

    public Task4(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        theLongestName = animals.stream()
            .max(Comparator.comparingInt(o -> o.name().length()))
            .get();
    }

    public Animal getAnimalWithLongestName() {
        return theLongestName;
    }
}
