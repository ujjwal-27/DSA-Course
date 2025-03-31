package algorithms.sorts.quickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 1, 7, 3, 2, 5};

        int resultIndex = pivot(array, 0, array.length - 1);

        System.out.println("Returned index: " + resultIndex);
        System.out.println(Arrays.toString(array));
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {

    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {

    }
}
