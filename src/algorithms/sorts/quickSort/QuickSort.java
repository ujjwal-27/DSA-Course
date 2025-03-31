package algorithms.sorts.quickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 1, 7, 3, 2, 5};

        int resultIndex = pivot(array, 0, array.length - 1);

        System.out.println("Returned index: " + resultIndex);
        System.out.println(Arrays.toString(array));
    }

    /**
     * In this method, 'swapIndex' is moved (or increased) only when an 'element' during iteration is smaller than 'pivot element'.
     * After that, element of 'swapIndex' and 'index-i' are swapped respectively.
     * This ensures, a greater element (swapIndex) and smaller element (i-index) than pivot element is swapped.
     * After the completion of iteration, all the smaller and greater elements will be arranged in a sequence.
     * Then, the 'pivot element' and 'element of swapIndex' is swapped.
     * This will arrange all the smaller elements to be in left sequence, and all the greater elements to be in right sequence of pivot element in the array.
     * @param array Array of integers
     * @param pivotIndex [Index]
     * @param endIndex [Integer]
     * @return The final index of pivot element, after swapping and rearrangement of the elements smaller and greater than pivot element.
     */
    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex; // swap index is always initialized at pivotIndex

        // The loop always starts after pivot index
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++; // swap index moves (or increase) only when the element is smaller than pivot element.
                swap(array, swapIndex, i);
            }
        }

        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    /**
     * This method simply swaps two elements of 'firstIndex' and 'secondIndex' respectively.
     * @param array Array of integers
     * @param firstIndex [Integer] Index of an element which is to be swapped with element of 'secondIndex'.
     * @param secondIndex [Integer] Index of an element which is to be swapped with element of 'firstIndex'.
     */
    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
