package edu.streams;

import edu.streams.util.AnimalSorter;
import edu.streams.util.task20.ValidationError;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Задача 20.
 * Сделать результат предыдущего задания более читабельным:
 * вернуть имя и названия полей с ошибками, объединенные в строку
 */
public final class Task20 extends AnimalSorter {
    private Map<String, String> validationErrorAnimals;

    public Task20(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        Map<String, Set<ValidationError>> allErrors = animals.stream()
            .collect(Collectors.groupingBy(
                Animal::name,
                Collectors.flatMapping(
                    animal ->
                        ValidationError.validateAnimal(animal).stream(),
                    Collectors.toSet()
                )
            ));

        validationErrorAnimals = allErrors.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                animalErrorLog -> animalErrorLog.getValue().stream()
                    .map(ValidationError::getErrorName)
                    .collect(Collectors.joining(", "))
            ));
    }

    public Map<String, String> getValidationErrorAnimals() {
        return validationErrorAnimals;
    }
}
