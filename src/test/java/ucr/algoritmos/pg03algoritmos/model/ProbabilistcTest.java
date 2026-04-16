package ucr.algoritmos.pg03algoritmos.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilistcTest {

    @Test
    public void randomSearchTest(){
        Probabilistic p = new Probabilistic();
        int[] arr = new Random().ints(100, 1, 100)
                .distinct().limit(100).toArray();
        System.out.println("Array: " + Arrays.toString(arr));

        for (int i = 0; i < 20; i++) {
            int value = new Random().nextInt(100);
            int attempts = new  Random().nextInt(10,50);
            int[] result = p.randomSearch(arr, value, attempts);

            System.out.println(
                    result[0] != -1 ? "Item [" + value + "] found in index: " + result[0] + ". Attempts: " + result[1] +
                            " Max attempts allowed: " + attempts
                            : "Item[" + value + "] not found. Max attempts: " + result[1]
            );
        }
    }

    @Test
    void millerRabinTest() {
        Probabilistic p = new Probabilistic();
        System.out.println("Rabin-Miler Probability for Big Numbers:");
        System.out.println("\nNumber: " + util.Utility.format(29341)
                + ": \n" + p.millerRabin("29341"));
        System.out.println("\nNumber: " + util.Utility.format(131071)
                + ": \n" + p.millerRabin("131071"));
        System.out.println("\nNumber: " + util.Utility.format(214748)
                + ": \n" + p.millerRabin("214748"));
        System.out.println("\nNumber: " + util.Utility.format(483647)
                + ": \n" + p.millerRabin("483647"));
        System.out.println("\nNumber: " + util.Utility.format(2147483647)
                + ": \n" + p.millerRabin("2147483647"));
        System.out.println("\nNumber: " + util.Utility.format(1000000007)
                + ": \n" + p.millerRabin("1000000007"));
        System.out.println("\nNumber: " + util.Utility.formatBig("2305843009213693951")
                + ": \n" + p.millerRabin("2305843009213693951"));
    }

}