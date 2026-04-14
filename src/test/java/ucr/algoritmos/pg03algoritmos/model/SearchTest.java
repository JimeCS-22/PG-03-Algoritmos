package ucr.algoritmos.pg03algoritmos.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void minMaxTest() {
        int[] arr = new Random().ints(100, 1, 100).toArray();
        System.out.println("\n" + Arrays.toString(arr));
    }

}