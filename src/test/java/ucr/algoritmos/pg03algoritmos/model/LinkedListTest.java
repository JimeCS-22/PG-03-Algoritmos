package ucr.algoritmos.pg03algoritmos.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void LinkedListTest() {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(20);
        linkedList.add(10);
        System.out.println(linkedList);


    }

}