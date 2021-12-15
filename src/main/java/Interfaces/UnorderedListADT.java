package Interfaces;

import Exceptions.ElementNotFoundException;

public interface UnorderedListADT<T>{
    /**
     * Adds the specified element to this list at
     * the front
     *
     * @param element
     */
    public void addToFront(T element);

    /**
     * Adds the specified element to this list at
     * the rear location
     *
     * @param element
     */
    public void addToRear(T element);

    /**
     * Adds the specified element after the a specified target
     * @param element
     * @param target
     */
    public void addAfter(T element, T target) throws ElementNotFoundException;
}
