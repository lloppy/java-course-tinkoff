package edu.streams.util;

import edu.streams.Animal;
import java.util.List;

public abstract class ListAnimalSorter {
    @SuppressWarnings("checkstyle:VisibilityModifier")
    protected final List<List<Animal>> animals;

    public ListAnimalSorter(final List<List<Animal>> animalGroups) {
        this.animals = animalGroups;
    }

    protected abstract void sortAnimals();
}
