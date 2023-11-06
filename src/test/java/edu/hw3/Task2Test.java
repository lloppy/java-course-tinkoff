package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw3.task2.Task2.clusterize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    @Test
    void testThatClusterizeWithSinglePairOfBracketsReturnedTrue() {
        List<String> list = clusterize("()");

        List<String> expected = new ArrayList<>(Arrays.asList("()"));

        assertEquals(expected, list);
    }

    @Test
    void testThatClusterizeWithTwoPairsOfBracketsReturnedTrue() {
        List<String> list = clusterize("()()");

        List<String> expected = new ArrayList<>(Arrays.asList("()", "()"));

        assertEquals(expected, list);
    }

    @Test
    void testThatClusterizeWithNestedBracketsReturnedTrue() {
        List<String> list = clusterize("((()))");

        List<String> expected = new ArrayList<>(Arrays.asList("((()))"));

        assertEquals(expected, list);
    }

    @Test
    void testThatClusterizeWithMultipleGroupsReturnedTrue() {
        List<String> list = clusterize("((()))(())()()(()())");

        List<String> expected = new ArrayList<>(Arrays.asList("((()))", "(())", "()", "()", "(()())"));

        assertEquals(expected, list);
    }

    @Test
    void testThatClusterizeWithMixedGroupsReturnedTrue() {
        List<String> list = clusterize("((())())(()(()()))");

        List<String> expected = new ArrayList<>(Arrays.asList("((())())", "(()(()()))"));

        assertEquals(expected, list);
    }

    @Test
    void testThatClusterizeWithMultipleIndividualBracketsReturnedTrue() {
        List<String> list = clusterize("()()()");

        List<String> expected = new ArrayList<>(Arrays.asList("()", "()", "()"));

        assertEquals(expected, list);
    }
}
