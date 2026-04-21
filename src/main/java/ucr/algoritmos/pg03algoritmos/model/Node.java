package ucr.algoritmos.pg03algoritmos.model;

public class Node<T> {

    public T data;
    public Node<T> next; //apuntador al nodo siguiente

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = null;//Por default que apunta a nulo
    }

    public Node(T data) {
        this.data = data;
    }
}
