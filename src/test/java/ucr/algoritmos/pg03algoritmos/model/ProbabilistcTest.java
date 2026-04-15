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
            int[] result = p.randomSearch(arr, value, 50);
            System.out.println(
                    result[0] != -1 ? "Item [" + value + "] found in index: " + result[0] + ". Attempts: " + result[1]
                            : "Item[" + value + "] not found. Max attempts: " + result[1]
            );
        }
    }

}