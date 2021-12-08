package Lists;

import Exceptions.ElementNotComparableException;
import Interfaces.OrderedListADT;

public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    public ArrayOrderedList() {
        this.array = (T[])(new Object[DEFAULT_CAPACITY]);
        this.rear = 0;
    }

    /**
     * Adds the specified element to this list at
     * the proper location
     *
     * @param element the element to be added to this list
     */
    @Override
    public void add(T element) throws ElementNotComparableException {
        if(!(element instanceof Comparable)) throw new ElementNotComparableException("Element is not comparable!");
        if(this.rear == array.length) {/*expandCapacity(); */}

        int i = 0;
        if(rear == 0){
            array[0] = element;
        }else {
            while (i != rear && ((Comparable<T>) element).compareTo(array[i]) > 0 ){
                i++;
            }
            if(i == rear){
                array[rear] = element;
            }else {
                shiftRight(i);
                array[i] =  element;
            }

        }
        this.rear++;
    }


    public String printAll(){
        String s = "";

        for(int i = 0; i < rear; i++){
            s += array[i] +" |";
        }


        return s;
    }


}
