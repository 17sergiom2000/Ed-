package Stacks;

import Exceptions.EmptyCollectionException;
import Interfaces.StackADT;
import Nodes.Node;

public class LinkedListStack<T> implements StackADT<T> {
    private Node<T> top;
    private int counter;

    public LinkedListStack(){}

    @Override
    public void push(T element) {
        Node<T> node = new Node<T>(element);

        if(!(isEmpty())) {
            node.setNext(top);
        }
        this.top = node;
        counter++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("Stack Empty");
        T result = top.getData();
        this.top = top.getNext();
        counter--;
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("Stack Empty");
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
      return counter == 0;
    }

    @Override
    public int size() {
        return counter;
    }
}
