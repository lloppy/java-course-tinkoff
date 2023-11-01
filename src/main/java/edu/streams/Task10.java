package edu.streams;

import edu.streams.util.AnimalSorter;
import java.util.List;

/**
 * Задача 10.
 * Список животных, возраст у которых не совпадает с количеством лап
 * -> List<Animal>
 */
public final class Task10 extends AnimalSorter {
    private List<Animal> ageNotMatchPawsAnimals;

    public Task10(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        ageNotMatchPawsAnimals = animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    public List<Animal> getAgeNotMatchPawsAnimals() {
        return ageNotMatchPawsAnimals;
    }
}
