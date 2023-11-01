package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Задача 3.
 * Сколько животных каждого вида -> Map<Animal.Type, Integer>
 */
public final class Task3 extends AnimalSorter {
    private Map<Animal.Type, Integer> sortedAnimals;

    public Task3(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        sortedAnimals = animals.stream()
            .collect(Collectors.groupingBy(
                    Animal::type,
                    Collectors.summingInt(animal -> 1)
                )
            );
    }

    public Map<Animal.Type, Integer> getSortedAnimals() {
        return sortedAnimals;
    }
}
