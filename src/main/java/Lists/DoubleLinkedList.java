package Lists;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.ListADT;
import Nodes.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract  class DoubleLinkedList<T> implements ListADT<T>{
    protected Node<T> head;
    protected Node<T> tail;
    protected int count;
    protected int modcount;

    /**
     * Removes and returns the first element from this list.
     *
             * @return the first element from this list
     */
    public T removeFirst() throws EmptyCollectionException{
        if (isEmpty()) throw new EmptyCollectionException("Collection is empty!");

        T elementToBeRemoved;

        elementToBeRemoved =  head.getNext().getData();

        head.setNext(head.getNext().getNext());
        head.getNext().setPrevious(head);
        this.count--;
        this.modcount++;
        return elementToBeRemoved;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     */
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Collection is empty!");

        T elementToBeRemoved;

        elementToBeRemoved =  tail.getPrevious().getData();

        tail.setPrevious(tail.getPrevious().getPrevious());
        tail.getPrevious().setNext(tail);
        this.count--;
        this.modcount++;
        return elementToBeRemoved;
    }

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) throw new EmptyCollectionException("Collection is empty!");

        Node<T> current = head.getNext();
        T elementToRemove;

        while (current != tail && !current.getData().equals(element)) {
            current = current.getNext();
        }


        if (current == tail) {
            throw new ElementNotFoundException("Element not found!");
        }
        elementToRemove = current.getData();


        (current.getPrevious()).setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());

        this.count--;
        this.modcount++;

        return elementToRemove;
    }

    /**
     * Returns a reference to the first element in this list.
     * @return a reference to the first element in this list
     */
    public T first (){
        return  head.getNext().getData();
    }

    /**
     * Returns a reference to the last element in this list.
     * @return a reference to the last element in this list
     */
    public T last (){
        return  tail.getPrevious().getData();
    }

    /**
     * Returns true if this list contains the specified target
     * element.
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains (T target){
        Node<T> current = head.getNext();
        boolean result = false;

        while (current != tail && !current.getData().equals(target)) {
            current = current.getNext();
        }

        if(current != tail){
            result = true;
        }

        return result;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    public boolean isEmpty(){
        return count==0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of
     * elements in this list
     */
    public int size(){
        return count;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */

    public Iterator<T> iterator(){
        return null;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString(){
        String s = "";

        if (isEmpty()) System.out.println("List is empty!");

        Node<T> current = this.head.getNext();

        while (current != tail) {
            s += current.getData().toString() + " |";
            current = current.getNext();
        }
        return s;
    }

    private class innerIterator implements Iterator<T>{

        private int expectedModcount;
        private Node<T> current;
        private boolean okToRemove;

        public innerIterator(){
            current = head.getNext();
            okToRemove = false;
            this.expectedModcount = modcount;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() throws NoSuchElementException{
            return current != tail;
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
            T next = current.getData();
            current = current.getNext();
            return next;
        }
    }

}
