package Lists;

import Exceptions.ElementNotComparableException;
import Interfaces.OrderedListADT;
import LinkedLists.DoubleLinkyList;
import Nodes.Node;

public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T>{

    public  DoubleLinkedOrderedList(){
        count = 0;
        head = new Node<>(null);
        tail = new Node<>(null);
        head.setNext(tail);
        tail.setPrevious(head);
    }

    /**
     * Adds the specified element to this list at
     * the proper location
     *
     * @param element the element to be added to this list
     */
    @Override
    public void add(T element) throws ElementNotComparableException {
        if (!(element instanceof Comparable)) throw new ElementNotComparableException("Element must be comparable!");

        Node<T> newElement = new Node<>(element);
        Node<T> current = head.getNext();

        while (current != tail && ((Comparable<T>) element).compareTo(current.getData()) > 0) {
            current = current.getNext();
        }

        current.getPrevious().setNext(newElement);
        newElement.setPrevious(current.getPrevious());
        current.setPrevious(newElement);
        newElement.setNext(current);

        this.count++;
        this.modcount++;

    }
}
