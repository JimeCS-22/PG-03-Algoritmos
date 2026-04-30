package ucr.algoritmos.pg03algoritmos.model;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void DoublyLinkedListTest() {

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(20);
        doublyLinkedList.add(10);

        for (int i = 0; i < 20; i++) {

            doublyLinkedList.add(new Random().nextInt(50));

        }
        System.out.println(doublyLinkedList);

        //quiero ver la data de ult nodo de la lista
        System.out.println("getHead " + doublyLinkedList.getHead().data);
        System.out.println("getTail " + doublyLinkedList.getTail().data);

        //Agregar en el primero
        System.out.println("------------------------");
        System.out.println("addFirst " );
        doublyLinkedList.addFirst(100);
        System.out.println(doublyLinkedList);
        System.out.println("addFirst ");
        doublyLinkedList.addFirst(200);
        System.out.println(doublyLinkedList);

        //Size
        System.out.println("------------------------");
        try {
            System.out.println("DoublyLinkedList size: " + doublyLinkedList.size());

            //Buscar elemento e index Of
            System.out.println("------------------------");
            for(int i = 0; i < 10; i++){
                int value = new Random().nextInt(50);
                System.out.println(doublyLinkedList.contains(value) ? "value [ " + value + " ] exists. Position:  "
                        + doublyLinkedList.indexOf(value)
                        : "value " + value +  " not found");
            }


            System.out.println("------------------------");
            System.out.println("Doubly Linked list getFirst " + doublyLinkedList.getFirst());
            System.out.println("Doubly Linked list getLast " + doublyLinkedList.getLast());
            System.out.println("------------------------");


            //Remove

            //Eliminar el primero
            //Eliminar el ultimo
            System.out.println("removeFirst: "+  doublyLinkedList.removeFirst());
            System.out.println("removeLast: "+  doublyLinkedList.removeLast());
            System.out.println("removeLast: "+  doublyLinkedList.removeLast());
            System.out.println("------------------------");
            System.out.println(doublyLinkedList);


            //Probamos Get
            int n =  doublyLinkedList.size();
            for (int i = 1; i<n; i++) {

                System.out.println("get ( " + i + " ) = " + doublyLinkedList.get(i) +
                        " | getPrev (" + doublyLinkedList.get(i) + ") = " + doublyLinkedList.getPrev(doublyLinkedList.get(i)) +
                        " | getNext (" + doublyLinkedList.get(i) + ") = " + doublyLinkedList.getNext(doublyLinkedList.get(i)));
            }

            //Ordernar

            //getPrev
            //getNext


        } catch (ListException e) {
            throw new RuntimeException(e);
        }

    }


    


}