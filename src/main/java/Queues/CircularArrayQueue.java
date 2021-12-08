package Queues;

import Exceptions.EmptyCollectionException;
import Exceptions.FullCollectionException;
import Interfaces.QueueADT;

import java.util.Arrays;

public class CircularArrayQueue<T> implements QueueADT {
    private T[] array;
    private int front, rear, counter;
    private final int DEFAULT_CAPACITY= 19;

    public CircularArrayQueue() {
        this.front = 0;
        this.rear = 0;
        this.counter = 0;
        this.array =  (T[])(new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to
     *                the rear of this queue
     */
    @Override
    public void enqueue(Object element)  {
        array[rear] = (T)element;
        rear = (rear+1) % array.length;
        counter++;
    }

    /**
     * Removes and returns the element at the front of
     * this queue.
     *
     * @return the element at the front of this queue
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("Queue Vazia!");
        T result = array[front];
        array[front] =  null;
        front = (front+1) % array.length;
        counter--;
        return result;
    }

    /**
     * Returns without removing the element at the front of
     * this queue.
     *
     * @return the first element in this queue
     */
    @Override
    public Object first() throws EmptyCollectionException {
        return array[front];
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size
     * of this queue
     */
    @Override
    public int size() {
        return counter;
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}
