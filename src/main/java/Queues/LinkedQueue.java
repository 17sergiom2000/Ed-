package Queues;

import Exceptions.EmptyCollectionException;
import Interfaces.QueueADT;
import Nodes.Node;

public class LinkedQueue<T> implements QueueADT {
    private Node<T> front;
    private Node<T> rear;
    private int counter;
    public LinkedQueue() {
        this.counter = 0;
    }

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to
     *                the rear of this queue
     */
    @Override
    public void enqueue(Object element) {
         Node node = new Node(element);
         if(counter == 0){
            this.front = node;
            this.rear = node;
         }else{
             this.rear.setNext(node);
             this.rear = node;
         }
         counter++;
    }

    /**
     * Removes and returns the element at the front of
     * this queue.
     *
     * @return the element at the front of this queue
     */
    @Override
    public Object dequeue() throws EmptyCollectionException {
        if(counter == 0){
            throw  new EmptyCollectionException("Lista Vazia");
        }

        Node temp = this.front;
        this.front = this.front.getNext();
        counter--;
        return temp;
    }

    /**
     * Returns without removing the element at the front of
     * this queue.
     *
     * @return the first element in this queue
     */
    @Override
    public Object first() throws EmptyCollectionException{
        if(counter == 0){
            throw  new EmptyCollectionException("Lista Vazia");
        }
        return front;
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
        String s = "";

        if(this.counter == 0) System.out.println("List is empty!");

        Node<T> current = this.front;
        while(current != null){
            s +=current.getData().toString() + " |";
            current = current.getNext();
        }
        return s;
    }
}
