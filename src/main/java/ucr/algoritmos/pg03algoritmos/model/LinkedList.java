package ucr.algoritmos.pg03algoritmos.model;

public class LinkedList <T> implements List<T>{

    private Node<T> head;//inicio de la lista
    private Node<T> tail;//Fin de la lista

    @Override
    public int size() throws ListException {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(T element) {

        Node<T> node = new Node<>(element);
        if (head == null) {
            head = node;
            tail = node;
        }

    }

    @Override
    public void addFirst(T element) {

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
