@Override
public T remove(T element) throws ListException {
    if (isEmpty()) throw new ListException("Doubly Linked List is empty");

    Node<T> aux = head;

    // buscar el nodo
    while (aux != null && !equals(aux.data, element)) {
        aux = aux.next;
    }

    if (aux == null) throw new ListException("Element not found");

    T data = aux.data;

    // CASO 1: borrar head
    if (aux == head) {
        head = head.next;
        if (head != null) head.prev = null; // si quedó vacía, head será null
        else tail = null;                    // la lista quedó vacía => tail también
        return data;
    }

    // CASO 2: borrar cualquier otro (medio o tail)
    aux.prev.next = aux.next;
    if (aux.next != null) aux.next.prev = aux.prev; // si era tail, aux.next es null
    else tail = aux.prev;                            // era tail, actualizar tail

    return data;
}
