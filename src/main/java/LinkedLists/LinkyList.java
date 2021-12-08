package LinkedLists;

import Nodes.Node;

public class LinkyList<T>{
    private Node head;
    private Node tail;
    public LinkyList(){}

    public void Add(T data){
        Node node = new Node(data);

        if(this.head == null){
            this.head = node;
        }else{
            Node iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(node);
        }
        this.tail = node;
    }

    public void Remove(int index){
        if(index == 0){
            this.head = head.getNext();
        }else{
            Node iterator = head;
            Node temp = null;
            for(int i=0;i<index-1;i++){
                iterator = iterator.getNext();
            }
            temp = iterator.getNext();
            iterator.setNext(temp.getNext());

        }
    }

    public void printAll(){
        Node iterator = head;
        while(iterator.getNext() != null){
            System.out.println(iterator.toString());
            iterator = iterator.getNext();
        }
        System.out.println(iterator.toString());
    }

}
