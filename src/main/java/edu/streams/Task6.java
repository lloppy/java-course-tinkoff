package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import static edu.streams.Animal.Type;

/**
 * Задача 6.
 * Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
 */
public final class Task6 extends AnimalSorter {
    private Map<Type, Animal> theLargestAnimals;

    public Task6(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        theLargestAnimals = animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                animal -> animal,
                BinaryOperator.maxBy(Comparator.comparing(Animal::weight))
            ));

    }

    public Map<Type, Animal> getTheLargestAnimals() {
        return theLargestAnimals;
    }
}
