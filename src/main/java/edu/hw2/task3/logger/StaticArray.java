package edu.hw2.task3.logger;

import java.util.ArrayList;

public final class StaticArray {

    private static ArrayList<String> values = new ArrayList<>();

    private StaticArray() {
    }

    public static void add(final String value) {
        values.add(value);
    }

    /* getFirst() и getLast() не могут быть пустыми
     *  -> нет проверки на размер
     */
    public static String getFirst() {
        return values.get(0);
    }

    public static String getLast() {
        return values.get(values.size() - 1);
    }
}
