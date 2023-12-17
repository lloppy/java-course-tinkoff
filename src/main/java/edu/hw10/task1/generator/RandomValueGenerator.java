package edu.hw10.task1.generator;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomValueGenerator {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Object generateRandomValue(final Parameter parameter) {
        Class<?> type = parameter.getType();

        if (type.isPrimitive() || Number.class.isAssignableFrom(type)) {
            return generateRandomNumberValue(type, parameter.getAnnotations());
        }

        if (type.equals(String.class)) {
            return generateRandomStringValue(parameter.getAnnotations());
        }

        throw new RuntimeException("No supported parameter`s types: " + type.getName());
    }

    private Object generateRandomNumberValue(
        final Class<?> type,
        final Annotation[] annotations
    ) {
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;

        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Min.class) {
                min = ((Min) annotation).value();
            } else if (annotation.annotationType() == Max.class) {
                max = ((Max) annotation).value();
            }
        }

        if (type.equals(int.class) || type.equals(Integer.class)) {
            return random.nextInt((int) min, (int) max);
        } else if (type.equals(long.class) || type.equals(Long.class)) {
            return random.nextLong((long) min, (long) max);
        } else if (type.equals(float.class) || type.equals(Float.class)) {
            return random.nextFloat() * (max - min) + min;
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            return random.nextDouble() * (max - min) + min;
        }

        throw new RuntimeException("No primitive value: " + type.getName());
    }

    private Object generateRandomStringValue(final Annotation[] annotations) {
        boolean notNull = Arrays.stream(annotations)
            .anyMatch(annotation -> annotation.annotationType() == NotNull.class);

        if (!notNull && random.nextBoolean()) {
            return null;
        }

        // выгладит как xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxxx
        // например: 550e8400-e29b-41d4-a716-446655440000
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
