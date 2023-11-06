package edu.hw3.task7;

import java.util.Comparator;

public final class NullComparator implements Comparator<String> {

    @Override
    public int compare(final String o1, final String o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return 1;
        } else if (o2 == null) {
            return -1;
        } else {
            return o1.compareTo(o2);
        }
    }
}

