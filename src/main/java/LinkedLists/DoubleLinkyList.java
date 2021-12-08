package LinkedLists;

import Nodes.Node;

public class DoubleLinkyList<T>{
    private Node head;
    private Node tail;
    private int count;
    public  DoubleLinkyList(){
        this.count = 0;
    }

    public void Add(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            this.head = this.tail = newNode;
            newNode.setPrevious(null);
            newNode.setNext(null);
        } else{
            newNode.setNext(head);
            head.setPrevious(newNode);
            this.head = newNode;
        }
        this.count++;
    }



    public void remove(T element){

        if(this.head == null){
            System.out.println("There is no element's!");
            return;
        }


        Node<T> current = this.head;

        while(current != null && !current.getData().equals(element)){
            current = current.getNext();
        }

        if(current.getPrevious() == null && current.getNext() == null){
            this.head = null;
            this.tail = null;
            current = null;
        } else if (current.getPrevious() == null && current.getNext() != null){              // 4 | 3 | 2
            this.head = current.getNext();
            current.getNext().setPrevious(null);
            current = null;
        } else if (current.getPrevious() != null && current.getNext() == null){
            this.tail = current.getPrevious();
            current.getPrevious().setNext(null);
            current = null;
        } else if (current.getPrevious() != null && current.getNext() != null){
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            current = null;
        }
        this.count--;
    }

    @Override
    public String toString(){
        String s = "";

        if(this.count == 0) System.out.println("List is empty!");

        Node<T> current = this.head;

        while(current != null){
            s += current.getData().toString() + " |";
            current = current.getNext();
        }

        return s;
    }
}
