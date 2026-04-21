package ucr.algoritmos.pg03algoritmos.model;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void LinkedListTest() {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(20);
        linkedList.add(10);

        for (int i = 0; i < 20; i++) {

            linkedList.add(new Random().nextInt(50));

        }
        System.out.println(linkedList);

        //quiero ver la data de ult nodo de la lista
        System.out.println("getHead " + linkedList.getHead().data);
        System.out.println("getTail " + linkedList.getTail().data);
        System.out.println("------------------------");
        System.out.println("addFirst " );
        linkedList.addFirst(100);
        System.out.println(linkedList);
        System.out.println("addFirst ");
        linkedList.addFirst(200);
        System.out.println(linkedList);



    }

}