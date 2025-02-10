package codingExercises.algorithms.sorts.insertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 6, 5, 1, 3};
        insertionSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    public static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int currentIndex = i;
            int previousIndex = i - 1;

            while (previousIndex >= 0 && numbers[currentIndex] < numbers[previousIndex]) {
                int temp = numbers[currentIndex];
                numbers[currentIndex] = numbers[previousIndex];
                numbers[previousIndex] = temp;

                currentIndex--;
                previousIndex--;
            }
        }
    }
}
