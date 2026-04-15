package ucr.algoritmos.pg03algoritmos.model;

import java.util.Random;

public class Probabilistic {

    /**
     * Busqueda aleatoria en un arreglo por medio de induces aleatorios
     * Se utiliza algoritmos probabilisticos
     * Devuelve un arreglo con el indice del valor buscado y el número de intentos realizadps
     * Si el indice es -1, el valor no se encontró el elemento total  de intentos realizados
     * */

    public int [] randomSearch (int [] arr, int value, int attempts){
        int[] result = new int[2];
        int count = 0;
        //Random random = new Random();

        while (true) {
            int index = new Random().nextInt(arr.length-1);
            count++;
            result[0] = index;
            result[1] = ++count;

            if (arr[index] == value) return result; //Si el indice del array es igual a la variable

            if (count>= attempts){
                result[0] = -1;
                return result;
            }
        }

    }
}



