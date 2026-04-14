package ucr.algoritmos.pg03algoritmos.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void minMaxTest() {
        int[] arr = new Random().ints(50, 10, 70).toArray();
        System.out.println("\n" + Arrays.toString(arr));
        Search.MinMax minMax = Search.findMinMax(arr, 0, arr.length - 1);
        System.out.println("Array min item: " + minMax.getMin()
        + "\nArray max item: " + minMax.getMax()) ;

        for (String s: Search.steps){
            System.out.println(s);
        }
    }

}