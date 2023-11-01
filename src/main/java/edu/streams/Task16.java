package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Задача 16.
 * Список животных, отсортированный по виду, затем по полу, затем по имени
 */
public final class Task16 extends AnimalSorter {

    private List<Animal> sortedAnimals;

    public Task16(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        sortedAnimals = animals.stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    public List<Animal> getSortedAnimals() {
        return sortedAnimals;
    }
}
