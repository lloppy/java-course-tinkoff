package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(final String brackets) {

        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder cluster = new StringBuilder();

        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') {
                stack.push(bracket);
                cluster.append(bracket);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    cluster.append(bracket);
                    if (stack.isEmpty()) {
                        result.add(cluster.toString());
                        cluster.setLength(0);
                    }
                }
            }
        }
        return result;
    }
}
