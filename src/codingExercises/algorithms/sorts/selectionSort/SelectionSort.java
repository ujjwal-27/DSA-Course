package codingExercises.algorithms.sorts.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 6, 5, 1, 3};
        selectionSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    /**
     * This algorithm implements nested for-loop.
     * The outer-loop starts from 0-index till 'second last' index of array.
     * - On every iteration of 'outer-loop', the variable 'minIndex' is created and initialized with the value of 'i'.
     * The 'outer-loop' starts from (i + 1) index till the 'last' index of array.
     * - On every iteration of 'inner-loop', the value at 'j-index' is compared with value at 'minIndex'.
     * - If value at 'j-index' is less than value at 'minIndex', the 'minIndex' is assigned with 'j-index'.
     * After the complete iteration of inner-loop, if 'minIndex != i', value at 'i' and 'minIndex' is swapped.
     * @param numbers Array of integers.
     */
    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex] ) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
        }
    }
}
