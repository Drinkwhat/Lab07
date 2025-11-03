package it.unibo.inner.api;

/**
 * This interface represents a predicate.
 * A predicate is a function that takes an element and returns a boolean.
 * @param <T> the type of the element to test.
 */
public interface Predicate<T> {
    /**
     * Tests the given element.
     * @param elem the element to test.
     * @return true if the element satisfies the predicate, false otherwise.
     */
    boolean test(T elem);
}
// package it.unibo.inner.impl;

// import java.util.Iterator;
// import java.util.NoSuchElementException;

// import it.unibo.inner.api.IterableWithPolicy;
// import it.unibo.inner.api.Predicate;

// public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    
//     private final T[] elements;
//     private Predicate<T> filter;

//     public IterableWithPolicyImpl(final T[] elements) {
//         this.elements = elements;
//         this.filter = null;
//     }

//     public IterableWithPolicyImpl(final T[] elements, final Predicate<T> filter) {
//         this.elements = elements;
//         this.filter = filter;
//     }

//     @Override
//     public Iterator<T> iterator() {
//         return new IteratorWithPolicy();
//     }

//     @Override
//     public void setIterationPolicy(final Predicate<T> filter) {
//         this.filter = filter;
//     }

//     /**
//      * Inner class that implements the Iterator interface with filtering policy.
//      */
//     private class  IteratorWithPolicy implements Iterator<T> {
//         private int currentIndex = 0;

//         @Override
//         public boolean hasNext() {
//             // Find the next element that satisfies the filter
//             while (currentIndex < elements.length) {
//                 if (filter == null || filter.test(elements[currentIndex])) {
//                     return true;
//                 }
//                 currentIndex++;
//             }
//             return false;
//         }

//         @Override
//         public T next() {
//             if (!hasNext()) {
//                 throw new NoSuchElementException();
//             }
//             return elements[currentIndex++];
//         }
//     }
// }
