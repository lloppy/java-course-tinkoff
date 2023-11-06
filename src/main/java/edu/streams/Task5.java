package edu.streams;

import edu.streams.Animal.Sex;
import edu.streams.util.AnimalSorter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Задача 5.
 * Каких животных больше: самцов или самок -> Sex
 */
public final class Task5 extends AnimalSorter {

    private Sex maxSexEntry;

    public Task5(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        Map<Animal.Sex, Long> sexCounts = animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));

        maxSexEntry = Objects.equals(sexCounts.get(Sex.F), sexCounts.get(Sex.M))
            ? null
            : sexCounts.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
    }

    public Sex getNumerousSexAnimals() {
        return maxSexEntry;
    }
}
