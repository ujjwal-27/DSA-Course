package interviewQuestions.hashTable.subarraySum;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int[] subarraySum(int[] nums, int target) {
        // In this map, 'key' represents sum of integers from each iteration, and 'value' represents the corresponding 'index' of that iteration.
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

        // Initialize 'sumIndexMap' with key -> 0 and value -> -1 which represents 'sum' and 'index' of each iteration respectively.
        // At some point, if the 'candidateKey' is 0, then it will point to this key-value pairs which means that sub-array starts from index 0.
        sumIndexMap.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // The core logic of this 'candidateKey' is that if this key is found in 'sumIndexMap', then it represents that there is contiguous sub-array in 'nums' array which add up to the target sum.
            // The contiguous array starts from the index i.e. 'requiredIndex' which is the corresponding 'value of candidateKey' + 1.
            int candidateKey = sum - target;

            if (sumIndexMap.containsKey(candidateKey)) {
                int requiredIndex = sumIndexMap.get(candidateKey) + 1;
                return new int[]{requiredIndex, i};
            }

            sumIndexMap.put(sum, i); // Putting current overall sum and index in 'sumIndexMap'
        }

        return new int[]{}; // If not candidateKey is found in 'sumIndexMap', this means there is no contiguous sub-array in 'nums' array which add up to the target sum. Hence, return empty array.
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []

        */

    }

}
