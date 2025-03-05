package codingExercises.sorts.insertionSort;

import java.util.Arrays;


public class Main {

    public static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j = i - 1;

            while (j >= 0 && temp < numbers[j]) {
                numbers[j + 1] = numbers[j];
                numbers[j] = temp;
                j--;
            }
        }
    }


    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        insertionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }

}
