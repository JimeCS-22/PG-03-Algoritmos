package ucr.algoritmos.pg03algoritmos.model;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void LinkedListTest()  {

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
            System.out.println("------------------------");
            System.out.println(linkedList);

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


    @Test
    public void LinkedListTest2() throws ListException{
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(20);
        linkedList.add(10);
        linkedList.add(15);
        linkedList.add(30);

        System.out.println(linkedList);
        System.out.println("------------------------");

        //Borrar
        System.out.println("Remove Firs -> " + linkedList.removeFirst());
        System.out.println("Remove Last -> " + linkedList.removeLast());
        System.out.println("Remove Last -> " + linkedList.removeLast());
        System.out.println("Remove Last -> " + linkedList.removeLast());
        System.out.println("------------------------");

        System.out.println(linkedList);
    }

    @Test
    public void personLinkedListTest(){
        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Student("1", "María", 19, 1.6, 56.5, "C12345"));
        linkedList.add(new Employee("2", "Carlos", 25, 1.73, 75, "Informático"));
        linkedList.add(new Student("3", "Mario", 22, 1.75, 76.3, "C67890"));
        linkedList.add(new Employee("4", "Ana", 30, 1.55, 60, "Profesora"));
        linkedList.add(new Student("5", "Paola", 21, 1.58, 60, "C85746"));
        linkedList.add(new Employee("6", "Juan", 32, 1.80, 78, "Paramédico"));
        System.out.println(linkedList); //mostramos la lista personas
        System.out.println("_".repeat(50));

        try {
            System.out.println("List size: "+linkedList.size());
            System.out.println("Removed first item: "+linkedList.removeFirst());

            Person person = linkedList.get(new Random().nextInt(linkedList.size()));
            System.out.println("_".repeat(50));
            System.out.println(
                    linkedList.contains(person)
                            ? "The person [" + person + "] exists in the list. " +
                            "Index: " + linkedList.indexOf(person)
                            : "The person [" + person + " does not exist in the list"
            );

            System.out.println("_".repeat(50));
            //probamos remove
            if (linkedList.contains(person)) {
                linkedList.remove(person);
                System.out.println("The person [" + person + "] has been deleted");
            }

        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        System.out.println("_".repeat(50));
        System.out.println(linkedList); //mostramos nuevamente la lista de personas


    }

}