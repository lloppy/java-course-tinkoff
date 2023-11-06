package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;

/**
 * Задача 13.
 * Список животных, имена которых состоят из более чем двух слов
 */
public final class Task13 extends AnimalSorter {
    private List<Animal> animalsWithLongName;

    public Task13(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        animalsWithLongName = animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    public List<Animal> getAnimalsWithLongName() {
        return animalsWithLongName;
    }
}
