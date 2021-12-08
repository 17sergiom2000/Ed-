package Stacks;

import Exceptions.EmptyCollectionException;
import Interfaces.StackADT;

public class ArrayStack<T> implements StackADT<T> {

    private T[] stack;
    private int top;
    private final int DEFAULT_CAPACITY= 100;

    public ArrayStack() {
        this.stack =  (T[])(new Object[DEFAULT_CAPACITY]);
        this.top = 0;
    }

    public ArrayStack(int initialCapacity) {
        this.stack =  (T[])(new Object[initialCapacity]);
        this.top = 0;
    }

    /**
     * Adds the specified element to the top of this stack,
     * expanding the capacity of the stack array if necessary.
     * @param element generic element to be pushed onto stack
     */
    @Override
    public void push(T element) {
        if(size() == stack.length){
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    /**
     * Removes the element at the top of this stack and
     * returns a reference to it.
     * Throws an Exceptions.EmptyCollectionException if the stack is empty.
     * @return T element removed from top of stack
     * @throws EmptyCollectionException if a pop
     * is attempted on empty stack
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty())
           throw new EmptyCollectionException("Stack Empty");

        top--;
        T result = stack[top];
        stack[top] = null;
        return  result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("Stack Empty");

        return stack[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    private void expandCapacity(){
        T[] tempStack = (T[])(new Object[stack.length +10]);
        System.arraycopy(stack,0,tempStack,0,stack.length);
        stack = tempStack;
    }

}
