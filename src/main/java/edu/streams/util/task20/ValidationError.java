package edu.streams.util.task20;

import edu.streams.Animal;
import java.util.HashSet;
import java.util.Set;
import static edu.streams.util.task20.ValidationError.ErrorType.NAME_CONTAINS_NUMBERS;
import static edu.streams.util.task20.ValidationError.ErrorType.NEGATIVE_AGE;
import static edu.streams.util.task20.ValidationError.ErrorType.NEGATIVE_HEIGHT;
import static edu.streams.util.task20.ValidationError.ErrorType.NEGATIVE_WEIGHT;
import static edu.streams.util.task20.ValidationError.ErrorType.SHORT_NAME;

public final class ValidationError {
    private final String errorName;

    public ValidationError(final ErrorType errorType) {
        this.errorName = errorType.getRussianName();
    }

    public enum ErrorType {
        SHORT_NAME("короткое имя"),
        NAME_CONTAINS_NUMBERS("имя содержит цифры"),
        NEGATIVE_AGE("отрицательный возраст"),
        NEGATIVE_HEIGHT("отрицательный рост"),
        NEGATIVE_WEIGHT("отрицательный вес");


        private final String russianName;

        ErrorType(final String enumName) {
            this.russianName = enumName;
        }

        public String getRussianName() {
            return russianName;
        }

    }

    public static Set<ValidationError> validateAnimal(final Animal animal) {
        Set<ValidationError> animalErrorSet = new HashSet<>();

        if (animal.name().length() <= 2) {
            animalErrorSet.add(new ValidationError(SHORT_NAME));
        }

        if (containsDigits(animal.name())) {
            animalErrorSet.add(new ValidationError(NAME_CONTAINS_NUMBERS));
        }

        if (animal.age() < 0) {
            animalErrorSet.add(new ValidationError(NEGATIVE_AGE));
        }

        if (animal.height() < 0) {
            animalErrorSet.add(new ValidationError(NEGATIVE_HEIGHT));
        }

        if (animal.weight() < 0) {
            animalErrorSet.add(new ValidationError(NEGATIVE_WEIGHT));
        }

        return animalErrorSet;
    }

    private static boolean containsDigits(final String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public String getErrorName() {
        return errorName;
    }
}
