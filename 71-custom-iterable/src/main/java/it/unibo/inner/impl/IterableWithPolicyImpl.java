package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    
    private final T[] elements;
    private Predicate<T> filter;


    public IterableWithPolicyImpl(final T[] elements) {
        this(
            elements,
            new Predicate<T>() {
                @Override
                public boolean test(T elem) {
                    return true;
                }
            }
        );
    }

    public IterableWithPolicyImpl(final T[] elements, final Predicate<T> filter) {
        this.elements = elements;
        this.filter = filter;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorWithPolicy();
    }

    @Override
    public void setIterationPolicy(final Predicate<T> filter) {
        this.filter = filter;
    }

    private class IteratorWithPolicy implements Iterator<T> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            while (currentIndex < elements.length) {
                if (filter.test(elements[currentIndex])) {
                    return true;
                }
                currentIndex++;
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[currentIndex++];
        }
    }

}
