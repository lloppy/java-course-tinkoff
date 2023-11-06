package edu.hw3.task8;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class BackwardIterator<T> implements Iterator<T> {
    private final List<T> listCollection;
    private int currentIndex;

    public BackwardIterator(final List<T> collection) {
        this.listCollection = collection;
        this.currentIndex = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return listCollection.get(currentIndex--);
    }
}

