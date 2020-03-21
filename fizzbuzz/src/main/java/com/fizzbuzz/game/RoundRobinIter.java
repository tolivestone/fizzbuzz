package com.fizzbuzz.game;

import java.util.Iterator;
import java.util.List;

// Custom iterator to iterate round robin.
public class RoundRobinIter<T> implements Iterable<T> {
    private List<T> collection;

    public RoundRobinIter(List<T> collection) { this.collection = collection; }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                T res = collection.get(index);
                index = (index + 1) % collection.size();
                return res;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }
}
