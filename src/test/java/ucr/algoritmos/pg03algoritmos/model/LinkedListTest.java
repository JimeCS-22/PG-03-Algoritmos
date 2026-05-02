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
        linkedList.add(new Student("María", "1", 19, 1.60, 56.5, "C12345"));
        linkedList.add(new Employee("Carlos", "2", 25, 1.73, 75.0, "Informático"));
        linkedList.add(new Student("Mario", "3", 22, 1.75, 76.3, "C67890"));
        linkedList.add(new Employee("Ana", "4", 30, 1.55, 60.0, "Profesora"));
        linkedList.add(new Student("Paola", "5", 21, 1.58, 60.0, "C85746"));
        linkedList.add(new Employee("Juan", "6", 32, 1.80, 78.0, "Paramédico"));
        System.out.println(linkedList); //mostramos la lista personas
        System.out.println("_".repeat(50));

        // f. En el método de testeo anterior, agregue 5 elementos más de cada tipo de
        //persona (estudiante y empleado)

        // Agregar 5 más de cada tipo (10 más)
        linkedList.add(new Student("Sofía", "7", 20, 1.65, 62.0, "C11111"));
        linkedList.add(new Student("Diego", "8", 23, 1.70, 70.0, "C22222"));
        linkedList.add(new Student("Lucía", "9", 21, 1.62, 60.2, "C33333"));
        linkedList.add(new Student("Andrés", "10", 22, 1.75, 75.0, "C44444"));
        linkedList.add(new Student("Valeria", "11", 20, 1.68, 64.5, "C55555"));

        linkedList.add(new Employee("Pedro", "12", 20, 1.62, 60.2, "Doctor/a"));
        linkedList.add(new Employee("Jimena", "13", 35, 1.70, 72.0, "Administrador/a"));
        linkedList.add(new Employee("Laura", "14", 28, 1.75, 75.0, "Docente"));
        linkedList.add(new Employee("Miguel", "15", 40, 1.65, 65.0, "Arquitecto/a"));
        linkedList.add(new Employee("Fernanda", "16", 30, 1.83, 80.0, "Periodista"));

        // Mostrar lista completa
        System.out.println(linkedList);
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

            System.out.println("_".repeat(50));
            System.out.println("FILTER i) Edad 20-23, Peso 60.2-75.0, Altura 1.62-1.75, Rol: Estudiante");
            System.out.println(getPersonList(linkedList, 20, 23, 60.2, 75.0, 1.62, 1.75, "Student"));

            System.out.println("_".repeat(50));
            System.out.println("FILTER ii) Edad 20-40, Peso 60.2-75.0, Altura 1.62-1.75, Rol: Empleado");
            System.out.println(getPersonList(linkedList, 20, 40, 60.2, 75.0, 1.62, 1.75, "Employee"));

            System.out.println("_".repeat(50));
            System.out.println("FILTER iii) Edad 25-36, Peso 55.4-80.0, Altura 1.62-1.83, Rol: Todos");
            System.out.println(getPersonList(linkedList, 25, 36, 55.4, 80.0, 1.62, 1.83, "All"));



        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        System.out.println("_".repeat(50));
        System.out.println(linkedList); //mostramos nuevamente la lista de personas


    }


    // Método pedido en la guía (g):  Como parte del testeo de la lista enlazada simple, cree un método llamado
    //“LinkedList<Person> getPersonList(LinkedList<Person> linkedList, …)”
    private LinkedList<Person> getPersonList(LinkedList<Person> linkedList, int minAge, int maxAge, double minWeight, double maxWeight, double minHeight, double maxHeight, String role) throws ListException {

        LinkedList<Person> filtered = new LinkedList<>();

        int n = linkedList.size();
        for (int i = 1; i <= n; i++) {
            Person p = linkedList.get(i);

            boolean ageOk = p.getAge() >= minAge && p.getAge() <= maxAge;
            boolean weightOk = p.getWeight() >= minWeight && p.getWeight() <= maxWeight;
            boolean heightOk = p.getHeight() >= minHeight && p.getHeight() <= maxHeight;

            if (!ageOk || !weightOk || !heightOk) continue;

            boolean roleOk = switch (role) {
                case "Student" -> p instanceof Student;
                case "Employee" -> p instanceof Employee;
                case "All" -> true;
                default -> false;
            };

            if (roleOk) filtered.add(p);
        }

        return filtered;
    }
}

