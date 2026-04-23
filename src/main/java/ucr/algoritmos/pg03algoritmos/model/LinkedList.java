package ucr.algoritmos.pg03algoritmos.model;

public class LinkedList<T> implements List<T> {

    private Node<T> head; //Inicio de la lista
    private Node<T> tail; //Fin de la lista

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public int size() throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
        int counter = 0;
        Node<T> aux = head;
        while (aux != null) {
            counter++;
            aux = aux.next;
        }
        return counter;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null; // Es recomendable limpiar tail también
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
        } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public void addFirst(T element) {
        Node<T> node = new Node<>(element);
        node.next = head;
        head = node;
        if (tail == null)
            tail = node; // si estaba vacío
    }

    @Override
    public void addLast(T element) {
        add(element); // el método add siempre agrega al final
    }

    @Override
    public void addInSortedList(T element) {
        Node<T> newNode = new Node<>(element);

        // Lista vacía o debe ir al inicio
        if (isEmpty() || ((Comparable<T>) element).compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null)
                tail = newNode;
            return;
        }

        Node<T> current = head;
        // Buscar dónde insertar
        while (current.next != null && ((Comparable<T>) element).compareTo(current.next.data) > 0) {
            current = current.next;
        }

        // Insertar después de current
        newNode.next = current.next;
        current.next = newNode;
        // Si se insertó al final, actualizar tail
        if (newNode.next == null)
            tail = newNode;
    }

    @Override
    public void remove(T element) throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");

        // Caso 1: Está en el head
        if (equals(head.data, element)) {
            head = head.next;
            if (head == null) tail = null; // Si la lista se vacía, tail también
        } else {
            Node<T> prev = head;
            Node<T> aux = head.next;
            while (aux != null && !(equals(aux.data, element))) {
                prev = aux;
                aux = aux.next;
            }
            if (aux != null && equals(aux.data, element)) {
                prev.next = aux.next;
                if (aux == tail) tail = prev; // Si era el último
            }
        }
    }

    @Override
    public T removeFirst() throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
        T first = head.data;
        head = head.next;
        if (head == null) tail = null;
        return first;
    }

    @Override
    public T removeLast() throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");

        Node<T> aux = head;
        Node<T> prev = head;
        while (aux.next != null) {
            prev = aux;//dejamos un rastro en el modo auxiliar
            aux = aux.next;
        }
        //Se sale del while cuando aux esta en el ultimo nodo
        T last = aux.data;//la data del nodo
        prev.next = null;
        tail = prev;//para que tail quede apuntando al ult nodo
        //Validacion si solo queda un nodo
        if (prev == aux) clear();//anulamos la lista
        return last;
    }

    @Override
    public boolean contains(T element) throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
        Node<T> aux = head;
        while (aux != null) {
            if (equals(aux.data, element)) return true;
            aux = aux.next;
        }
        return false;
    }

    @Override
    public void sort() throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
        int n = size();
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                Node<T> nodeI = getNode(i);
                Node<T> nodeJ = getNode(j);
                if (util.Utility.compare(nodeJ.data, nodeI.data) < 0) {
                    T temp = nodeI.data;
                    nodeI.data = nodeJ.data;
                    nodeJ.data = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(T element) throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
        Node<T> aux = head;
        int index = 1; // Primer elemento es 1, si deseas cambia a 0
        while (aux != null) {
            if (equals(aux.data, element)) return index;
            index++;
            aux = aux.next;
        }
        return -1;
    }

    @Override
    public T getFirst() throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
        return head.data;
    }

    @Override
    public T getLast() throws ListException {
        if (isEmpty())
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
                    return prev.data;
                } else {
                    throw new ListException("It's the first element, it has no prev");
                }
            }
            prev = aux;
            aux = aux.next;
        }
        throw new ListException("Element does not exist in Linked List");
    }

    @Override
    public T getNext(T element) throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");

        Node<T> aux = head;
        while (aux != null && aux.next != null) {
            if (equals(aux.data, element)) {
                return aux.next.data;
            }
            aux = aux.next;
        }
        throw new ListException("Element has no next or does not exist in Linked List");
    }

    @Override
    public T get(int index) throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
        if (index < 1 || index > size())
            throw new ListException("Index out of bounds");
        Node<T> aux = head;
        int count = 1;
        while (aux != null) {
            if (count == index) {
                return aux.data;
            }
            count++;
            aux = aux.next;
        }
        return null; // Nunca debería llegar aquí por el control anterior
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HEAD ➡️");
        Node<T> aux = head;

        while (aux != null) {
            sb.append("[").append(aux.data).append("]");
            if (aux.next != null) sb.append("➡️");
            aux = aux.next;
        }
        sb.append("➡️ NULL ");
        return sb.toString();
    }

    /* ---- AYUDAS----- */
    private boolean equals(T a, T b) {
        return a == null ? b == null : a.equals(b);
    }

    private Node<T> getNode(int index) throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
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

    private Node<T> getNode(T element) throws ListException {
        if (isEmpty())
            throw new ListException("Linked List is empty");
        Node<T> aux = head;
        while (aux != null) {
            if (equals(aux.data, element)) return aux;
            aux = aux.next;
        }
        return null;
    }
}