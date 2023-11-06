package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;

/**
 * Задача 11.
 * Список животных, которые могут укусить (bites == true)
 * и рост которых превышает 100 см
 */
public final class Task11 extends AnimalSorter {
    public static final int MIN_HEIGHT = 100;
    private List<Animal> canBiteAnimalsHigher100;

    public Task11(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        canBiteAnimalsHigher100 = animals.stream()
            .filter(animal -> animal.bites())
            .filter(animal -> animal.height() > MIN_HEIGHT)
            .toList();
    }

    public List<Animal> getCanBiteAnimalsHigher100() {
        return canBiteAnimalsHigher100;
    }
}
