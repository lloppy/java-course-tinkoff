package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.Comparator;
import java.util.List;

/**
 * Задача 2.
 * Отсортировать животных по весу от самого тяжелого к самому легкому,
 * выбрать k первых
 */
public final class Task2 extends AnimalSorter {
    private List<Animal> sortedAnimals;
    private int limiter;

    public Task2(final List<Animal> animals, final int k) {
        super(animals);
        this.limiter = k;
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        sortedAnimals = animals.stream()
            .sorted(Comparator.comparing(Animal::weight).reversed())
            .limit(limiter)
            .toList();
    }

    public List<Animal> getSortedAnimals() {
        return sortedAnimals;
    }
}
