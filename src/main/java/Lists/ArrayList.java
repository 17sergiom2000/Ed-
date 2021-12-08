package Lists;

import Exceptions.EmptyCollectionException;
import Interfaces.ListADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class ArrayList<T> implements ListADT<T>{
    protected static final int DEFAULT_CAPACITY = 100;
    protected T[] array;
    protected int rear;
    private int modcount;

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if(isEmpty()) throw new EmptyCollectionException("Collection is empty!");
        T element = array[0];
        shiftLeft(0);
        this.rear--;
        this.modcount++;
        return element;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     */
    public T removeLast(){
        T element = array[rear-1];
        array[rear-1] = null;
        this.rear--;
        this.modcount++;
        return element;
    }
    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element){
        for(int index= 0;index<array.length;index++){
            if(array[index].equals(element)){
                T result = array[index];
                shiftLeft(index);
                this.rear--;
                this.modcount++;
                return result;
            }
        }
        return null;
    }
    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    @Override
    public T first() {
        return array[0];
    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    @Override
    public T last() {
        return array[rear-1];
    }

    /**
     * Returns true if this list contains the specified target
     * element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        for (T element : array) {
            if(element.equals(target))
                return true;
        }
        return false;
    }
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty(){
        return this.rear == 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of
     * elements in this list
     */
    @Override
    public int size() {
        return rear;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator(rear,array,modcount);
    }

    /**
     * Shift the array Left
     * @param istart
     */
    private void shiftLeft(int istart){
        for(int j = istart; j < rear-1; j++){
            array[j] = array[j+1];
        }
    }

    /**
     * Shift the array Right
     * @param istart
     */
    public void shiftRight(int istart){
        for(int i = rear; i > istart; i--){
            array[i] = array[i-1];
        }
    }


    private class ArrayIterator implements Iterator<T> {

        private final int size;
        private T[] items;
        private int current;
        private int expectedModCount;
        private boolean okToRemove;

        public ArrayIterator(int size, T[] items,int expectedModCount) {
            this.size = size;
            this.items = items;
            this.current = 0;
            this.expectedModCount = expectedModCount;
            this.okToRemove = false;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException("No such element!");
            okToRemove = true;
            return items[current++];
        }
        @Override
        public void remove() {
            if(modcount != expectedModCount) throw new ConcurrentModificationException("Canno't use the same method at same time!");
            if(!okToRemove) throw new IllegalStateException("No method next was called!");
            ArrayList.this.remove(array[current-1]);
            expectedModCount++;
            current--;
            okToRemove = false;
        }
    }

}

