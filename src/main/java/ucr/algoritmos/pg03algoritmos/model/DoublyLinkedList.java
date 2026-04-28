package ucr.algoritmos.pg03algoritmos.model;

public class DoublyLinkedList<T> implements List<T>{

    private Node<T> head; //Inicio de la lista
    private Node<T> tail; //Fin de la lista

    public DoublyLinkedList(Node<T> head, Node<T> tail) {
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() throws ListException {
        if(isEmpty()) throw new ListException("Doubly Linked List is empty");
        return 0;
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

    }

    @Override
    public void addFirst(T element) {

        Node<T> node = new Node<>(element);

        if (isEmpty()) {

            head = tail = node;

        }else{

            node.next = head;
            head.prev = node;
            head = node;
        }

    }

    @Override
    public void addLast(T element) {

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
        return false;
    }

    @Override
    public void sort() throws ListException {

    }

    @Override
    public int indexOf(T element) throws ListException {
        return 0;
    }

    @Override
    public T getFirst() throws ListException {
        return null;
    }

    @Override
    public T getLast() throws ListException {
        return null;
    }

    @Override
    public T getPrev(T element) throws ListException {
        return null;
    }

    @Override
    public T getNext(T element) throws ListException {
        return null;
    }

    @Override
    public T get(int index) throws ListException {
        return null;
    }
}
