package codingExercises.sorts.mergeSort.codingExercise93;

import java.util.Arrays;


public class Main {

    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }

    /**
     * While understanding recursion, always try to break down the steps, and draw an illustration of elements being stacked and popped from a memory container.
     * Everytime the method is called through recursion, that particular instance is stacked in the memory.
     * And everytime a return statement is executed, current instance from the memory pops out.
     * @param array Unsorted array of integers.
     * @return Sorted array of integers.
     */
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length/2;

        int[] left = Arrays.copyOfRange(array, 0, midIndex);
        left = mergeSort(left); // recursion

        int[] right = Arrays.copyOfRange(array, midIndex, array.length);
        right = mergeSort(right); // recursion

        return merge(left, right);
    }


    public static void main(String[] args) {

        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "Original Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Original Array: [3, 1, 4, 2]

            Sorted Array: [1, 2, 3, 4]

         */

    }

}

