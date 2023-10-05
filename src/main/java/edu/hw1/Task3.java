package edu.hw1;

import org.apache.logging.log4j.core.appender.rolling.action.IfAll;
import static java.lang.Math.min;

public class Task3 {

    public static Boolean isNestable(int[] a1, int[] a2) {

        if (a1.length != 0 && a2.length != 0) {
            return findMin(a1) > findMin(a2) ||
                findMax(a1) < findMin(a2);
        } else return false;
    }

    public static int findMin(int[] a) {
        int min = Integer.MAX_VALUE;

        for (var number : a) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    public static int findMax(int[] a) {
        int max = Integer.MIN_VALUE;

        for (var number : a) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }
}
