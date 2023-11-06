package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;
import static java.util.Comparator.comparingInt;

/**
 * Задача 7.
 * K-е самое старое животное -> Animal
 */
public final class Task7 extends AnimalSorter {
    private Animal theOldestAnimal;

    public Task7(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        theOldestAnimal = animals.stream()
            .max(comparingInt(Animal::age))
            .get();

    }

    public Animal getTheOldestAnimal() {
        return theOldestAnimal;
    }
}
