package Nodes;

public class Node<T>{
    private T data;
    private Node<T> next;
    private Node<T> previous;
    public Node(T data ){
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public String toString(){
        return data + " ";
    }

}
