package ucr.algoritmos.pg03algoritmos.model;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    void add() throws ListException {
        //a. Agregue 50 valores numéricos no repetidos a la lista y muestre la lista por consola
        DoublyLinkedList<Integer> listNumbers = new DoublyLinkedList<>();
        for (int i = 0; i < 50; i++) {
            listNumbers.add(i);
        }
        System.out.println(listNumbers);
        //b. Pruebe los métodos: getFirst y getLast
        System.out.println( "getFirst("+listNumbers.getFirst() + ")");
        System.out.println( "getLast("+listNumbers.getLast() + ")");

    }

    @Test
    void DoublyLinkedListTest() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.add(20);
        linkedList.add(10);

        for (int i = 0; i < 20; i++) {

            linkedList.add(new Random().nextInt(50));

        }
        System.out.println(linkedList);

        //quiero ver la data de ult nodo de la lista
        System.out.println("getHead " + linkedList.getHead().data);
        System.out.println("getTail " + linkedList.getTail().data);

        //Agregar en el primero
        System.out.println("------------------------");
        System.out.println("addFirst " );
        linkedList.addFirst(100);
        System.out.println(linkedList);
        System.out.println("addFirst ");
        linkedList.addFirst(200);
        System.out.println(linkedList);

        //Size
        System.out.println("------------------------");
        try {
            System.out.println("LinkedList size: " + linkedList.size());

            //Buscar elemento e index Of
            System.out.println("------------------------");
            for(int i = 0; i < 10; i++){
                int value = new Random().nextInt(50);
                System.out.println(linkedList.contains(value) ? "value [ " + value + " ] exists. Position:  "
                        + linkedList.indexOf(value)
                        : "value " + value +  " not found");
            }


            System.out.println("------------------------");
            System.out.println("Linked list getFirst " + linkedList.getFirst());
            System.out.println("Linked list getLast " + linkedList.getLast());
            System.out.println("------------------------");


            //Remove

            //Eliminar el primero
            //Eliminar el ultimo
            System.out.println("removeFirst: "+  linkedList.removeFirst());
            System.out.println("removeLast: "+  linkedList.removeLast());
            System.out.println("removeLast: "+  linkedList.removeLast());
            linkedList.remove(100);
            System.out.println("remove: 100");
            System.out.println("------------------------");
            System.out.println(linkedList);

            /*c. Realice una búsqueda en la lista de 20 valores aleatorios. Si encuentra el
        valor deberá mostrar su posición en la lista, el elemento anterior y el
        elemento posterior.*/

            //Probamos Get
            int n =  linkedList.size();
            for (int i = 1; i<n; i++) {

                System.out.println("get ( " + i + " ) = " + linkedList.get(i) +
                        " | getPrev (" + linkedList.get(i) + ") = " + linkedList.getPrev(linkedList.get(i)) +
                        " | getNext (" + linkedList.get(i) + ") = " + linkedList.getNext(linkedList.get(i)));
            }

            //Ordernar

            //getPrev
            //getNext


        } catch (ListException e) {
            throw new RuntimeException(e);
        }

    }


    


}