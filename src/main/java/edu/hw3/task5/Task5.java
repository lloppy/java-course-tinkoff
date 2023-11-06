package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    private Task5() {
    }

    public static List<Person> parseContacts(String[] stringPersons, String rule) {
        List<Person> persons = new ArrayList<>();

        for (String fullName : Arrays.asList(stringPersons)) {
            persons.add(new Person(fullName));
        }

        Collections.sort(persons, Comparator.comparing(Person::getLastName));

        if ("DESC".equals(rule)) {
            Collections.reverse(persons);
        }

        return persons;
    }
}
