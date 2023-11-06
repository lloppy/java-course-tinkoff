package edu.streams.util;

import edu.streams.Animal;
import java.util.List;

public abstract class AnimalSorter {
    @SuppressWarnings("checkstyle:VisibilityModifier")
    protected List<Animal> animals;

    public AnimalSorter(final List<Animal> animalsList) {
        this.animals = animalsList;
    }

    protected abstract void sortAnimals();
}
