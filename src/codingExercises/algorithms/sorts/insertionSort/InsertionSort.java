package codingExercises.algorithms.sorts.insertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 6, 5, 1, 3};
        insertionSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    /**
     * COURSE BASED: Using 'shifting elements' approach. (Efficient and recommended)
     * Here, 'nested loop' is implemented.
     * In outer loop, two variables 'temp' and 'j' is defined.
     * - 'temp' is assigned with value of current index 'i', whereas 'j' is assigned with preceding index.
     * The inner loop is executed while 'j' is greater than and equals to '0', and while 'temp' is less than value at 'j-index'. This is where the core shifting logic is implemented.
     * - On each iteration, the value of 'preceding index' i.e. 'j' is assigned to (j + 1) index.
     * - And, on the 'j-index', 'temp' is assigned. These two steps, shift the values between two indices.
     * - Then, j is decremented by 1.
     * @param numbers Arrays of integers
     */
    public static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j = i - 1; // previous index

            while (j >= 0 && temp < numbers[j]) {
                numbers[j + 1] = numbers[j]; // Here, use (j + 1) instead of using 'i' directly, because on each iteration value of 'i' remains same which makes shifting of elements inaccurate.
                numbers[j] = temp;

                j--;
            }
        }
    }

    /**
     * SELF IMPLEMENTATION: Using 'swap' approach.
     * Here, 'nested loop' is implemented.
     * In outer loop, two variables 'currentIndex' and 'previousIndex' is defined.
     * - 'currentIndex' is assigned with current index, whereas 'previousIndex' is assigned with index before currentIndex.
     * The inner loop is executed while 'previousIndex' is greater than and equals to '0', and while value of 'currentIndex' is less than 'previousIndex'.
     * - Here, the value between 'previousIndex' and 'currentIndex' is swapped.
     * - Then, both 'currentIndex' and 'previousIndex' is decremented by '1'. This is done to get track of the 'actual value' in 'currentIndex'.
     * @param numbers Arrays of integers
     */
//    public static void insertionSort(int[] numbers) {
//        for (int i = 1; i < numbers.length; i++) {
//            int currentIndex = i;
//            int previousIndex = i - 1;
//
//            while (previousIndex >= 0 && numbers[currentIndex] < numbers[previousIndex]) {
//                int temp = numbers[currentIndex];
//                numbers[currentIndex] = numbers[previousIndex];
//                numbers[previousIndex] = temp;
//
//                currentIndex--;
//                previousIndex--;
//            }
//        }
//    }
}
