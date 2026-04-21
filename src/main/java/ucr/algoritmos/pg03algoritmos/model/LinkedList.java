package ucr.algoritmos.pg03algoritmos.model;

public class LinkedList <T> implements List<T>{

    private Node<T> head;//inicio de la lista
    private Node<T> tail;//Fin de la lista


    public LinkedList() {
    }

    public LinkedList(Node<T> head, Node<T> tail) {
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public int size() throws ListException {
            if(isEmpty())
                throw new ListException("Linked List is empty");
            int counter = 0; //contador de nodos
            Node<T> aux = head; //aux para moverme por la lista y no perder el puntero al inicio
            while(aux!=null){
                counter++;
                aux = aux.next;
            }
            return counter;
    }

    @Override
    public void clear() {

        this.head = null;

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(T element) {

        Node<T> node = new Node<>(element);
        if (head == null) {
            head = node;
            tail = node;
        }else{//Significa que head apunta a un nodo existente
            Node<T> aux = head;
            //Me muevo por la lista hasta alcanzar el ultimo elemento
            while(aux.next!=null){
                aux = aux.next;//lo mueve al siguiente nodo
            }
            //Cuando se sale del while aux.next == null
            aux.next = node;
            tail = node; //Lo ponemos a apuntar al ultimo nodo de la lista
        }

    }

    @Override
    public void addFirst(T element) {

        Node<T> node = new Node<>(element);
        node.next = head;
        head = node;//Pq el nuevo nodo quede de primero


    }

    @Override
    public void addLast(T element) {
        add(element);//El metodo add por default agrega a final

    }

    @Override
    public void addInSortedList(T element) {

    }

    @Override
    public void remove(T element) throws ListException {

    }

    @Override
    public T removeFirst() throws ListException {
        return null;
    }

    @Override
    public T removeLast() throws ListException {
        return null;
    }

    @Override
    public boolean contains(T element) throws ListException {
        if(isEmpty())
            throw new ListException("Linked List is empty");
        Node<T> aux = head;//aux para moverme en la lista
        while(aux!=null){
            if(equals(aux.data, element)) return true; //ya lo encontro
            aux = aux.next; //muevo aux al nodo sgte
        }
        return false; //significa que no encontro el elemento
    }



    @Override
    public void sort() throws ListException {


    }

    @Override
    public int indexOf(T element) throws ListException {
        if(isEmpty())
            throw new ListException("Linked List is empty");
        Node<T> aux = head;
        int index = 1; //el primer indice de la lista es 1
        while(aux!=null){
            if(equals(aux.data, element)) return index;
            index++;
            aux = aux.next;
        }
        return -1; //significa q el elemento no existe en la lista
    }

    @Override
    public T getFirst() throws ListException {
        if(isEmpty())
            throw new ListException("Linked List is empty");
        return head.data;
    }

    @Override
    public T getLast() throws ListException {
        if(isEmpty())
            throw new ListException("Linked List is empty");

        return tail.data;
    }

    @Override
    public T getPrev(T element) throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");

        Node<T> aux = head;
        Node<T> prev = null;

        while (aux != null) {
            if (equals(aux.data, element)) {
                if (prev != null) {
                    return prev.data; // Retorna el dato anterior.
                } else {
                    throw new ListException("It's the first element, it has no prev");
                }
            }
            prev = aux;
            aux = aux.next;
        }
        // Si llegamos aquí, el elemento no está en la lista
        throw new ListException("Element does not exist in Linked List");
    }

    @Override
    public T getNext(T element) throws ListException {
        return null;
    }

    @Override
    public T get(int index) throws ListException {

        if (isEmpty())
            throw new ListException("Linked List is empty");

        Node<T> aux = head;
        int count = 1;

        while(aux!=null){
            if (count ++== index) {
                return aux.data;
            }
        }

        return null;
    }

    @Override
    public String toString() {

        StringBuilder  sb = new StringBuilder("HEAD ➡️");
        Node<T> aux = head;

        while (aux != null){

            sb.append("[").append(aux.data).append("]");

            if (aux.next != null) sb.append("➡️");

            aux = aux.next;


        }

        sb.append("➡️ NULL ");

        return sb.toString();
    }

    /* ---- AYUDAS-----*/
    private boolean equals(T a, T b){

        return a== null ? b== null : a.equals(b);

    }

    private Node<T> getNode(T element) throws ListException {
        if (isEmpty()) throw new ListException("Linked List is empty");
        Node<T> aux = head;
        while (aux!=null){
            if (equals(aux.data, element)) return aux;
            aux = aux.next;
        }

        return null;
    }
}
