package Lists;

import Interfaces.UnorderedListADT;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{

    public ArrayUnorderedList(){
        this.array = (T[])(new Object[DEFAULT_CAPACITY]);
        this.rear = 0;
    }

    public ArrayUnorderedList(int capacity){
        this.array = (T[])(new Object[capacity]);
        this.rear = 0;
    }

    @Override
    public void addToFront(T element) {


        if(this.rear == 0){
            array[rear] = element;
        } else{
            shiftRight(0);
            array[0] = element;
        }
        this.rear++;
        this.modcount++;
    }

    @Override
    public void addToRear(T element) {


        array[rear] = element;
        this.rear++;
        this.modcount++;
    }

    @Override
    public void addAfter(T element, T target) {


        int i = 0;
        while(!array[i].equals(target)){
            i++;
        }
        shiftRight(i+1); //Tirar +1, n faz diferença
        array[i+1] = element;
        this.rear++;
        this.modcount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new innerIterator();
    }

    public String toString(){
        String s = "";

        for(int i = 0; i < rear; i++){
            s += array[i] +" |";
        }
        return s;
    }

    private class innerIterator implements Iterator<T>{
        private int expectedModcount;
        private int current;
        private boolean okToRemove;

        public innerIterator(){
            this.current = 0;
            okToRemove = false;
            this.expectedModcount = modcount;
        }

        @Override
        public boolean hasNext() {
            return (current < rear) && array[current] != null;
        }

        @Override
        public T next() throws NoSuchElementException{
            if(!hasNext()) throw new NoSuchElementException("No such element!");
            okToRemove = true;

            return array[current++];
        }

        @Override
        public void remove(){
            if(expectedModcount != modcount) throw new ConcurrentModificationException("Canno't use the same method at same time!");
            if(!okToRemove) throw new IllegalStateException("Can't remove!");
            remove(current);
            okToRemove = false;
        }

        private void remove(int current) {
            array[current] = null;
            int i = current;

            shiftLeft(i);

            rear--;
            this.expectedModcount++;
            modcount++;
        }
    }
}
