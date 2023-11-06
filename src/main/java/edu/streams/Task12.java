package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;

/**
 * Задача 12.
 * Сколько в списке животных, вес которых превышает рост -> Integer
 */
public final class Task12 extends AnimalSorter {
    private Integer weightExceedsHeightAnimalsCount;

    public Task12(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        weightExceedsHeightAnimalsCount = (int) animals.stream()
            .filter(animal -> animal.height() < animal.weight())
            .count();
    }

    public Integer getWeightExceedsHeightAnimals() {
        return weightExceedsHeightAnimalsCount;
    }
}
