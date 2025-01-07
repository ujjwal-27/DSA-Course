package interviewQuestions.hashTable.twoSum;

import java.util.*;


public class Main {

    /**
     * In this method, first an empty HashMap is created which accepts both key and value of type Integer.
     * Then for-loop is executed on 'nums' array:
     * On each iteration, 'current number' is subtracted from 'target' value.
     * The difference gives the 'possible candidate number' which might be present in the 'numMap' as a 'key'.
     * If the candidate number is found in the 'numMap' as key, then its value which represents its 'index', and the index no: 'i' of current iteration is returned as an array.
     * This is because, sum of current number and candidate number will definitely result to target number.
     * If the candidate number is not present in the 'numMap', then the 'current number' and its 'index' will be added to 'numMap' as 'key' and 'value' respectively.
     * This 'current number' added to numMap can be the 'candidate number' in one of the next iterations.
     * After the complete execution of for-loop, if no pair of numbers is found which when added result to target value, then return empty array.
     *
     * @param nums Array of integers
     * @param target Required sum value
     * @return Array of integers which contains 'index' of two numbers from 'nums' array, the sum of which results to 'target' value.
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>(); // This hash map takes 'current number' from nums array as 'key', and its 'index' as 'value'

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int candidate = target - currentNum; // The resulting difference is the required number which when added to current number results to target value.

            if (numMap.containsKey(candidate)) { // Check if the candidate is present in the numMap as key.
                return new int[]{numMap.get(candidate), i}; // If true, return an array with the index of the candidate (i.e. its corresponding value in numMap), and index 'i' from current iteration.

            } else {
                numMap.put(currentNum, i); // If false, then add the number and index from current iteration in the numMap.
            }
        }

        return new int[]{}; // If no pair of numbers is found which when added result to target value, then return empty array.
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

    }

}

