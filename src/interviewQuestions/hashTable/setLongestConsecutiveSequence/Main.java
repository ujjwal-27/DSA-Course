package interviewQuestions.hashTable.setLongestConsecutiveSequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static int longestConsecutiveSequence(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> intSet = new HashSet<>();

        for (int num: nums) {
            intSet.add(num);
        }

        List<Integer> intList = new ArrayList<>(intSet);
        intList.sort((a, b) -> {
            if (b <= a) {
                return 1;
            }

            return -1;
        });

        int longestSequence = 0;
        int sequence = 0;

        System.out.println(intList);
        for (int i = 1; i < intList.size(); i++) {
            if (intList.get(i) - intList.get(i - 1) == 1) {
                sequence++;

            } else {
                if (sequence > longestSequence) {
                    longestSequence = sequence;
                }

                sequence = 0;
            }
        }

        if (sequence > 0 && sequence > longestSequence) {
            longestSequence = sequence;
        }

        return longestSequence + 1;
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

