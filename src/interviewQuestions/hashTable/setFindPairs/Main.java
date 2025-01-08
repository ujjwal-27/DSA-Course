package interviewQuestions.hashTable.setFindPairs;

import java.util.*;


public class Main {

    /**
     * First, create an empty HashSet (intSet) and ArrayList (pairList).
     * Then, add all the integers from 'arr1' to 'intSet' using for-loop.
     * Then, using for-loop, find the 'difference' between 'target value' and 'integers' of arr2 on each iteration.
     * On each iteration, check if the 'difference' value is present in 'intSet' or not.
     * If yes, then the 'difference' value and respective 'integer' from 'arr2' is a pair which sums to 'target' value.
     * Create an array (pairArr) of those two pair integers, and add the 'array' to 'pairList'.
     * Lastly, return 'pairList'.
     * @param arr1 Array of integers
     * @param arr2 Array of integers
     * @param target Integer
     * @return List of integer array
     */
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> intSet = new HashSet<>();
        List<int[]> pairList = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            intSet.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            int difference = target - arr2[i];

            if (intSet.contains(difference)) {
                int[] pairArr = new int[]{difference, arr2[i]};
                pairList.add(pairArr);
            }
        }

        return pairList;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */

    }

}


