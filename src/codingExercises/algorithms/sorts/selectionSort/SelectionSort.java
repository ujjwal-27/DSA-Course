package codingExercises.algorithms.sorts.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 6, 5, 1, 3};
        selectionSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    public static void selectionSort(int[] numbers) {
        int minIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
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

            minIndex = i + 1;
        }
    }
}
