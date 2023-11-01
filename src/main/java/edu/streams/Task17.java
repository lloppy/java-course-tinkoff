package edu.streams;

import edu.streams.Animal.Type;
import edu.streams.util.AnimalSorter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static edu.streams.Animal.Type.DOG;
import static edu.streams.Animal.Type.SPIDER;
import static java.util.stream.Collectors.groupingBy;

/**
 * Задача 17.
 * Правда ли, что пауки кусаются чаще, чем собаки
 * -> Boolean (если данных для ответа недостаточно, вернуть false)
 */
public final class Task17 extends AnimalSorter {
    private Boolean isSpidersBiteOftenDogs;

    public Task17(final List<Animal> animals) {
        super(animals);
        sortAnimals();
    }

    @Override
    protected void sortAnimals() {
        Map<Type, Long> countByBites = animals.stream()
            .filter(animal ->
                (animal.type() == DOG || animal.type() == SPIDER)
                    && animal.bites())
            .collect(groupingBy(Animal::type, Collectors.counting()));

        Long spiderCount = countByBites.get(SPIDER);
        Long dogCount = countByBites.get(DOG);

        if (spiderCount != null && dogCount != null) {
            isSpidersBiteOftenDogs = spiderCount > dogCount;
        } else {
            isSpidersBiteOftenDogs = false;
        }
    }

    public Boolean isSpidersBiteOftenDogs() {
        return isSpidersBiteOftenDogs;
    }
}
