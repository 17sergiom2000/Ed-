package LinkedLists;

import Nodes.Node;

public class LinkyListSentinela<T>{
    private Node SentinelHead;
    private Node SentinelTail;
    private int counter;
    public LinkyListSentinela(){
        SentinelHead = new Node(null);
        SentinelTail = new Node(null);
        SentinelHead.setNext(SentinelTail);
    }

    public void Add(T data){
        Node newNode = new Node(data);
        newNode.setNext(SentinelHead.getNext());
        SentinelHead.setNext(newNode);
        counter++;
    }

    public void Remove(T element){
        if(counter == 0){
            System.out.println("Não há elementos na lista");
        }
        Node iterator = SentinelHead.getNext();
        Node previous = SentinelHead;
        while(iterator.getNext() != null && !(iterator.getData().equals(element)) ){
            iterator = iterator.getNext();
            previous = previous.getNext();
        }
        previous.setNext(iterator.getNext());


        counter--;
    }

    public void printAll(){
        Node iterator = SentinelHead;
        while(iterator.getNext() != null){
            System.out.println(iterator.toString());
            iterator = iterator.getNext();
        }
        System.out.println(iterator.toString());
    }

}
