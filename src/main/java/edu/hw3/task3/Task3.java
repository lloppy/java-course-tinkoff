package edu.hw3.task3;

import java.util.HashMap;
import java.util.Map;

public final class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(final T[] items) {
        Map<T, Integer> result = new HashMap<>();

        for (T item : items) {
            if (!result.containsKey(item)) {
                result.put(item, 1);
            } else {
                int newValue = result.get(item) + 1;
                result.replace(item, newValue);
            }
        }
        return result;
    }
}
