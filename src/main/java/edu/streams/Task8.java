package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Задача 8.
 * Самое тяжелое животное среди животных ниже k см -> Optional<Animal>
 */
public final class Task8 extends AnimalSorter {
    private int edgeOfHeight;
    private Optional<Animal> theOldestAnimal;

    public Task8(final List<Animal> animals, final int k) {
        super(animals);
        this.edgeOfHeight = k;
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        theOldestAnimal = Optional.of(animals.stream()
            .filter(animal -> animal.height() < edgeOfHeight)
            .max(Comparator.comparingInt(Animal::weight)).get());
    }

    public Optional<Animal> getTheOldestAnimal() {
        return theOldestAnimal;
    }
}
