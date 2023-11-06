package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BackwardIteratorTest {

    @Test
    public void testThatIterateReturnsValuesInReverseOrder() {
        Integer[] list = {1, 2, 3};
        BackwardIterator<Integer> iterator = new BackwardIterator<>(Arrays.asList(list));

        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testThatEmptyListReturnsFalseForHasNext() {
        Integer[] list = {};
        BackwardIterator<Integer> iterator = new BackwardIterator<>(Arrays.asList(list));

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testThatIterateArrayListReturnsValuesInReverseOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);

        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testThatIterateLinkedListReturnsValuesInReverseOrder() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);

        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testThatEmptyArrayListReturnsFalseForHasNext() {
        ArrayList<Integer> list = new ArrayList<>();
        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);

        assertFalse(iterator.hasNext());
    }
}
