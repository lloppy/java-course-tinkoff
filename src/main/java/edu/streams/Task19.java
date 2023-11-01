package edu.streams;

import edu.streams.util.AnimalSorter;
import edu.streams.util.task19.ValidationError;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Задача 19.
 * Животные, в записях о которых есть ошибки: вернуть имя и список ошибок
 * -> Map<String, Set<ValidationError>>.
 * <p>
 * Класс ValidationError и набор потенциальных проверок нужно придумать самостоятельно.
 */
public final class Task19 extends AnimalSorter {
    private Map<String, Set<ValidationError>> validationErrorAnimals;

    public Task19(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        validationErrorAnimals = animals.stream()
            .collect(Collectors.groupingBy(
                Animal::name,
                Collectors.flatMapping(
                    animal ->
                        ValidationError.validateAnimal(animal).stream(),
                    Collectors.toSet()
                )
            ));
    }

    public Map<String, Set<ValidationError>> getValidationErrorAnimals() {
        return validationErrorAnimals;
    }
}
