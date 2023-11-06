package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;
import static java.util.Comparator.comparingInt;

/**
 * Задача 1.
 * Отсортировать животных по росту
 * от самого маленького к самому большому
 */
public final class Task1 extends AnimalSorter {
    private List<Animal> sortedAnimals;

    public Task1(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        sortedAnimals = animals.stream()
            .sorted(comparingInt(Animal::height))
            .toList();
    }

    public List<Animal> getSortedAnimals() {
        return sortedAnimals;
    }
}
