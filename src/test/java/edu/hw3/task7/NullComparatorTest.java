package edu.hw3.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NullComparatorTest {

    @Test
    void testThatTreeMapAllowsNullKeyWithCustomComparator() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator());
        tree.put(null, "test");

        assertEquals(true, tree.containsKey(null));
    }

    @Test
    public void testThatTreeMapAllowsDoNotContainsNull() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator());

        // no null key
        tree.put("harry", "Gryffindor");
        tree.put("ron", "Gryffindor");
        tree.put("hermione", "Gryffindor");

        assertEquals(false, tree.containsKey(null));
    }

    @Test
    public void testThatTreeMapWithCustomComparatorWorksAsExpected() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator());

        tree.put("harry", "potter");
        tree.put("ron", "weasley");
        tree.put("hermione", "granger");

        String[] expectedKeys = {"harry", "hermione", "ron"};
        List<String> actualKeys = new ArrayList<>(tree.keySet());

        for (int i = 0; i < expectedKeys.length; i++) {
            assertEquals(expectedKeys[i], actualKeys.get(i));
        }
    }
}
