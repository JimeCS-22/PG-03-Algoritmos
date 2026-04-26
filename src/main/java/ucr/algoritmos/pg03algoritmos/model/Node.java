package ucr.algoritmos.pg03algoritmos.model;

import javafx.beans.property.SimpleStringProperty;

public class Node<T> {

    public T data;
    public Node<T> next; //apuntador al nodo siguiente
    public Node<T> prev;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = null;//Por default que apunta a nulo
    }

    public Node(T data) {
        this.data = data;
    }

    public Node() {
        this.data = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    //esta clase es para llenar de una mejor manera la tabla de Linked List
    public static class NodeInfo {
        private final String posicion;
        private final String valor;
        private final String referencia;

        public NodeInfo(String posicion, String valor, String referencia) {
            this.posicion = posicion;
            this.valor = valor;
            this.referencia = referencia;
        }

        public String getPosicion() { return posicion; }
        public String getValor() { return valor; }
        public String getReferencia() { return referencia; }
    }

}
