package ucr.algoritmos.pg03algoritmos.model;

public class DoublyLinkedList<T> implements List<T>{

    private Node<T> head;

    //Constructor
    public DoublyLinkedList(Node<T> head) {
        this.head = head;
    }

    @Override
    public int size() throws ListException {

        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        int count = 0;
        Node<T> aux = head;

        while (aux != null) {
            count++;
            aux = aux.next;
        }

        return count;
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

        if (isEmpty()) head = node;
        else {

            Node<T> aux = head;// aux para moverme por la lista y no perder el puntero de inicio
            while (aux.next != null) {
                aux = aux.next;// mueve aux al nodo siguiente
            }
            //Se sale del while cuando aux esta en el ultimo nodo
            aux.next = node;
            //hago el doble enlace
            node.prev = aux;
        }

    }

    @Override
    public void addFirst(T element) {

        Node<T> node = new Node<>(element);

        if (isEmpty()) head = node;
        else {
            node.next = head;
            //Hago el doble enlace
            head.prev = node;
            head = node;
        }

    }

    @Override
    public void addLast(T element) {
        add(element);

    }

    @Override
    public void addInSortedList(T element) {
        Node<T> node = new Node<>(element);

        if (isEmpty()) {
            head = node;
            return;
        }

        Comparable<T> comp = (Comparable<T>) element;

        // Insertar al inicio
        if (comp.compareTo(head.data) <= 0) {
            node.next = head;
            head.prev = node;
            head = node;
            return;
        }

        Node<T> aux = head;

        while (aux.next != null && comp.compareTo(aux.next.data) > 0) {
            aux = aux.next;
        }

        node.next = aux.next;
        if (aux.next != null) aux.next.prev = node;

        aux.next = node;
        node.prev = aux;

    }

    @Override
    public void remove(T element) throws ListException {

        if(isEmpty()) throw new ListException("Doubly Linked List is empty");

        //Caso 1: EL elemento a suprimir es el primero de la lista
        if (equals(head.data, element)) {
            head = head.next;
            head.prev = null;//actualizo el enlace al nodo anterior
        }

        //Caso 2: El elemnto puede estar en el medio o al final
        else {

            Node<T> prev = head;// nodo anterior
            Node<T> aux = head.next;//nodo siguiente

            while(aux != null && !equals(aux.data, element)) {
                prev = aux;
                aux = aux.next;
            }

            //Se sale del while cuando alcanza nulo o cuando se encuentra el elemento
            if (aux!= null && equals(aux.data, element)) {
                //Se debe de desenlazar el nodo
                prev.next = aux.next;
                //mantego el doble enlace
                if(aux.next != null) aux.next.prev = prev;
            }
        }


    }

    @Override
    public T removeFirst() throws ListException {
        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        T value = head.data;
        head = head.next;//se mueve el apuntador al nodo siguiente

        //Se rompe el doble enlace
        if(head != null) head.prev = null;

        return value;

    }

    @Override
    public T removeLast() throws ListException {
        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        if(head.next == null){
            //Solo un nodo
            T value = head.data;
            head = null;
            return value;
        }

        Node<T> aux = head;

        while(aux.next != null){
            aux = aux.next;
        }

        T  value = aux.data;
        aux.prev.next = null;//romper el enlace

        return value;
    }

    @Override
    public boolean contains(T element) throws ListException {

        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        Node<T> aux = head;

        while (aux != null) {
            if (equals(aux.data, element)) return true;//ya lo encontro
            aux = aux.next;//muevo el aux al nodo siguiente
        }

        return false;
    }

    @Override
    public void sort() throws ListException {

        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        boolean swapped;

        do {
            swapped = false;
            Node<T> aux = head;

            while (aux.next != null) {
                Comparable<T> a = (Comparable<T>) aux.data;

                if (a.compareTo(aux.next.data) > 0) {
                    // intercambiar datos
                    T temp = aux.data;
                    aux.data = aux.next.data;
                    aux.next.data = temp;

                    swapped = true;
                }
                aux = aux.next;
            }

        } while (swapped);

    }

    @Override
    public int indexOf(T element) throws ListException {
        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        Node<T> aux = head;
        int index = 1;

        while (aux != null) {
            if (equals(aux.data, element)) return index;
            index++;
            aux = aux.next;
        }
        return -1;
    }

    @Override
    public T getFirst() throws ListException {
        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        return head.data;
    }

    @Override
    public T getLast() throws ListException {

        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        Node<T> aux = head;

        while (aux != null) {
            aux = aux.next;
        }

        return aux.data;
    }

    @Override
    public T getPrev(T element) throws ListException {

        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        Node<T> aux = head;

        while (aux != null) {
            if (equals(aux.data, element)) {
                return (aux.prev != null) ? aux.prev.data : null;
            }
        }

        return null;
    }

    @Override
    public T getNext(T element) throws ListException {

        if (isEmpty()) throw new ListException("Doubly Linked List is empty");

        Node<T>  aux = head;

        while (aux != null) {
            if (equals(aux.data, element)) {
                return (aux.next != null) ? aux.next.data : null;
            }

            aux = aux.next;
        }
        return null;
    }

    @Override
    public T get(int index) throws ListException {
        return getNode(index).data;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> aux = head;

        while (aux != null) {
            sb.append("[");

            sb.append(aux.prev != null ? aux.prev.data : "NULL");
            sb.append(" ⬅️");
            sb.append(aux.data);
            sb.append(" ➡️ ");
            sb.append(aux.next != null ? aux.next.data : "NULL");

            sb.append("]");

            if (aux.next != null) sb.append(" ↔ ");
            aux = aux.next;
        }

        return sb.toString();
    }

    /* ---- AYUDAS----- */
    private boolean equals(T a, T b) {
        return a == null ? b == null : a.equals(b);
    }

    private Node<T> getNode(int index) throws ListException {
        if (isEmpty())
            throw new ListException(" Doubly Linked List is empty");
        if (index < 1 || index > size())
            throw new ListException("Index out of bounds");
        Node<T> aux = head;
        int count = 1;
        while (aux != null) {
            if (count == index) return aux;
            count++;
            aux = aux.next;
        }
        return null;
    }
}
