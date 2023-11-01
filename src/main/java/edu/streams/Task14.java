package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;

/**
 * Задача 14.
 * Есть ли в списке собака ростом более k см -> Boolean
 */
public final class Task14 extends AnimalSorter {
    private int lowerBoundOfHeight;

    private Boolean isDogExist;

    public Task14(final List<Animal> animals, final int k) {
        super(animals);
        this.lowerBoundOfHeight = k;
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        isDogExist = animals.stream()
            .anyMatch(animal -> animal.height() > lowerBoundOfHeight);
    }

    public Boolean getDogExist() {
        return isDogExist;
    }
}
