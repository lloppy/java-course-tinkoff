package edu.hw3;

import edu.hw3.task5.Person;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw3.task5.Task5.parseContacts;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {

    @Test
    void testThatParseContactsASC() {

        String[] persons = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String rule = "ASC";

        List<Person> parseContacts = parseContacts(persons, rule);

        String[] excepted = {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"};

        for (int i = 0; i < excepted.length; i++) {
            assertEquals(excepted[i], parseContacts.get(i).getFullPersonName());
        }
    }

    @Test
    void testThatParseContactsDESC() {
        String[] persons = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String rule = "DESC";

        List<Person> parseContacts = parseContacts(persons, rule);

        String[] excepted = {"Carl Gauss", "Leonhard Euler", "Paul Erdos"};

        for (int i = 0; i < excepted.length; i++) {
            assertEquals(excepted[i], parseContacts.get(i).getFullPersonName());
        }
    }

    @Test
    void testThatParseContactsNullEmpty() {
        String[] persons = {null};
        String rule = "DESC";

        List<Person> parseContacts = parseContacts(persons, rule);

        String[] excepted = {};

        for (int i = 0; i < excepted.length; i++) {
            assertEquals(excepted[i], parseContacts.get(i).getFullPersonName());
        }
    }

    @Test
    void testThatParseContactsEmpty() {
        String[] persons = {};
        String rule = "DESC";

        List<Person> parseContacts = parseContacts(persons, rule);

        String[] excepted = {};

        for (int i = 0; i < excepted.length; i++) {
            assertEquals(excepted[i], parseContacts.get(i).getFullPersonName());
        }
    }

    @Test
    void testThatParseContactsASCNoLastName() {

        String[] persons = {"John", "Thomas Aquinas", "David", "Rene Descartes"};
        String rule = "ASC";

        List<Person> parseContacts = parseContacts(persons, rule);

        String[] excepted = {"Thomas Aquinas", "David", "Rene Descartes", "John"};

        for (int i = 0; i < excepted.length; i++) {
            assertEquals(excepted[i], parseContacts.get(i).getFullPersonName());
        }
    }

    @Test
    void testThatParseContactsDESCNoLastName() {
        String[] persons = {"Paul Erdos", "Leonhard", "Carl Gauss"};
        String rule = "DESC";

        List<Person> parseContacts = parseContacts(persons, rule);

        String[] excepted = {"Leonhard", "Carl Gauss", "Paul Erdos"};

        for (int i = 0; i < excepted.length; i++) {
            assertEquals(excepted[i], parseContacts.get(i).getFullPersonName());
        }
    }
}
