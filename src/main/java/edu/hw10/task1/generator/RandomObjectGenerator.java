package edu.hw10.task1.generator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class RandomObjectGenerator {
    private final RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final Class<?> currentClass;

    public RandomObjectGenerator(final Class<?> currentClass) {
        this.currentClass = Objects.requireNonNull(currentClass, "Class cannot be null");
    }

    public <T> T nextObject() {
        Constructor<?> constructor = getRandomConstructor(currentClass.getDeclaredConstructors());
        return createObject(constructor);
    }

    public <T> T nextObject(final String factoryMethodName) {
        Method factoryMethod = getFactoryMethod(currentClass, factoryMethodName);
        return createObject(factoryMethod);
    }

    private Constructor<?> getRandomConstructor(final Constructor<?>[] constructors) {
        return constructors[random.nextInt(constructors.length)];
    }

    private Method getFactoryMethod(final Class<?> tClass, final String factoryMethodName) {
        return Arrays.stream(tClass.getMethods())
            .filter(method -> method.getName().equals(factoryMethodName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No existing method: " + factoryMethodName));
    }

    private <T> T createObject(final Constructor<?> constructor) {
        try {
            Parameter[] parameters = constructor.getParameters();
            return (T) constructor.newInstance(getArguments(parameters));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T createObject(final Method factoryMethod) {
        try {
            Parameter[] parameters = factoryMethod.getParameters();
            return (T) factoryMethod.invoke(null, getArguments(parameters));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] getArguments(final Parameter[] parameters) {
        return Arrays.stream(parameters)
            .map(randomValueGenerator::generateRandomValue)
            .toArray();
    }
}
