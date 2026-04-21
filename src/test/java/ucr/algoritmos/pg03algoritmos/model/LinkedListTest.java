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


    }

}