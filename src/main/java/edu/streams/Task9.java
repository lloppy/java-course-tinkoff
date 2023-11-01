package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;

/**
 * Задача 9.
 * Сколько в сумме лап у животных в списке -> Integer
 */
public final class Task9 extends AnimalSorter {
    private Integer sumAllPaws;

    public Task9(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        sumAllPaws = animals.stream()
            .mapToInt((s) -> (s.paws())).sum();
    }

    public int getSumAllPaws() {
        return sumAllPaws;
    }
}
