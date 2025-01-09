package interviewQuestions.hashTable.setLongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;


public class Main {

    /**
     * The core concept implemented in this method is:
     * First, populate all the integers to an empty set 'numSet'. This will remove all the duplicate value from the array.
     * Initialize a variable 'longestSequence' with 0, to calculate the longest sequence in 'numSet'.
     * Then, execute advanced for-loop on 'numSet', and do following for each integer 'num':
     * - Check if (num - 1) exists or not in 'numSet'. If exists, move to another number in next iteration because the existence of (num - 1) reflects that current 'num' is already part of a 'sequence' which begin from another number less than 'num'.
     * - If it doesn't exist, initialize two variables 'currentNum' assigned with value of 'num', and 'currentSequence' assigned with 1.
     * - Then, while there exists (currentNum + 1) in numSets, increment both currentNum and currentSequence by 1. This will compute any 'sequence' present in the 'numSet'.
     * - After that, compare 'longestSequence' and 'currentSequence' using 'Math.max()' method, and assign the max value to 'longestSequence',
     * Finally, return 'longestSequence'.
     * @param nums Array of integers
     * @return [Integer] Longest sequence in array 'nums'.
     */
    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            numSet.add(num);
        }

        int longestSequence = 0;

        /**
         * Here, instead of 'advanced for-loop', we might think of using 'forEach loop' which implements 'lambda expression': 'numSet.forEach((num) -> {})'.
         * But, there are certain rules that need to be considered before using lambda expression.
         * The logic inside the loop requires modification of 'longestSequence' which is a local variable.
         * Inside lambda expression, modification of local variables is never possible as the compiler will throw an error.
         * A local variable must be declared 'final' before using it inside lambda expression.
         * To modify values of variable in lambda, use:
         * - An array or object as a wrapper for the value.
         * - Instance variable in which the modification rules does not imply.
         * - Atomic variables for thread-safe numeric operations.
         */
        for (int num: numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequence++;
                }

//                if (currentSequence > longestSequence) {
//                    longestSequence = currentSequence;
//                }

                longestSequence = Math.max(longestSequence, currentSequence);
            }
        };

        return longestSequence;
    }

    public static void main(String[] args) {
        testLongestConsecutiveSequence("Consecutive Integers", new int[] {1, 2, 3, 4, 5}, 5);
        testLongestConsecutiveSequence("No Sequence", new int[] {1, 3, 5, 7, 9}, 1);
        testLongestConsecutiveSequence("Duplicates", new int[] {1, 2, 2, 3, 4}, 4);
        testLongestConsecutiveSequence("Negative Numbers", new int[] {1, 0, -1, -2, -3}, 5);
        testLongestConsecutiveSequence("Empty Array", new int[] {}, 0);
        testLongestConsecutiveSequence("Multiple Sequences", new int[] {1, 2, 3, 10, 11, 12, 13}, 4);
        testLongestConsecutiveSequence("Unordered Elements", new int[] {5, 1, 3, 4, 2}, 5);
        testLongestConsecutiveSequence("Single Element", new int[] {1}, 1);
        testLongestConsecutiveSequence("All Identical Elements", new int[] {2, 2, 2, 2, 2}, 1);
    }

    /**
     * Test method for longestConsecutiveSequence.
     * @param title Title of the test
     * @param nums Input array
     * @param expected Expected result
     */
    private static void testLongestConsecutiveSequence(String title, int[] nums, int expected) {
        System.out.println("Test: " + title);
        System.out.print("Testing array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int result = longestConsecutiveSequence(nums);
        System.out.println("Expected longest streak: " + expected);
        System.out.println("Actual longest streak: " + result);

        if (result == expected) {
            System.out.println("PASS\n");
        } else {
            System.out.println("FAIL\n");
        }
    }

}

