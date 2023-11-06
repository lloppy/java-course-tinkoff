package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Задача 15.
 * Найти суммарный вес животных каждого вида,
 * которым от k до l лет
 */
public final class Task15 extends AnimalSorter {
    private int lowerBoundOfAge;
    private int upperBoundOfAge;

    private Map<Animal.Type, Integer> sumWeighInBounds;

    public Task15(final List<Animal> animals, final int k, final int l) {
        super(animals);
        this.lowerBoundOfAge = k;
        this.upperBoundOfAge = l;
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        sumWeighInBounds = animals.stream()
            .filter(animal -> lowerBoundOfAge <= animal.age()
                && animal.age() <= upperBoundOfAge)
            .collect(groupingBy(Animal::type, summingInt(Animal::weight)));
    }

    public Map<Animal.Type, Integer> getSumWeighInBounds() {
        return sumWeighInBounds;
    }
}
