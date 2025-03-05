package algorithms.sorts.bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 6, 5, 1, 3};
        bubbleSort(numbers);

        System.out.println(Arrays.toString(numbers));
     }

    /**
     * Here, nested for-loop is used.
     * Every adjacent elements in the array is compared with each other.
     * Initially, this is done starting from 0-index to the last index of the array.
     * - In next phase (iteration) of outer-loop it is done starting from 0-index to the second-last index of the array.
     * - In each iteration (phase) of outer-loop, the index from the end is reduced by 1, until it reaches index-1.
     * In inner loop, the comparison of adjacent elements are done.
     * - If the left element is greater than right element, they are swapped.
     * @param numbers [Array of integers]
     */
    public static void bubbleSort(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}
