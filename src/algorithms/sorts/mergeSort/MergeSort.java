package algorithms.sorts.mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] originalArray = {3, 1, 4, 2};
        int[] sortedArray = mergeSort(originalArray);

        System.out.println("Original array: " + Arrays.toString(originalArray));
        System.out.println("-------------------------------------------------");
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    /**
     * This method takes two sorted arrays, and merge then into one single sorted array.
     * @param array1 Sorted array of integers.
     * @param array2 Sorted array of integers
     * @return Sorted array of integers resulted from the combination of array1 and array2.
     */
    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0; // for combined array
        int i = 0; // for array1
        int j = 0; // for array2

        /*
         * This while-loop is executed until one of the variables 'i' or 'j' is smaller than 'array1' and 'array2' respectively.
         * After this while-loop breaks, there will be elements left in one of the arrays.
         * Those elements will be added to 'combined' array through another while-loop.
         */
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                i++;

            } else {
                combined[index] = array2[j];
                j++;
            }

            index++;
        }

        // This while-loop will be executed if there are elements remaining in array1.
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }

        // This while-loop will be executed if there are elements remaining in array2.
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }

        return combined;
    }

    /**
     * This method breaks the array into half until each array has only one element.
     * It uses recursion for this. 
     * @param array Array of unsorted integers
     * @return Array of sorted integers
     */
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array; // base case

        int midIndex = array.length/2;

        // This creates copy of elements of array from 0-index to midIndex, but not including midIndex.
        int[] left = Arrays.copyOfRange(array, 0, midIndex);
        left = mergeSort(left); // recursion

        // This creates copy of elements of array from midIndex to length of the array. Meaning, until the last element of the array.
        int[] right = Arrays.copyOfRange(array, midIndex, array.length);
        right = mergeSort(right); // recursion

        return merge(left, right);
    }
}
