package interviewQuestions.hashTable.findDuplicates;

import java.util.*;


public class Main {

    /**
     * Self implemented solution
     * @param nums Array of integers
     * @return Duplicate list
     */
    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>(); // HashMap for storing values from 'nums' integer array.
        List<Integer> duplicates = new ArrayList<>(); // ArrayList for storing duplicate values

        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;

            // If the number from 'nums' array already exists in the map as one of the keys, then flag will be assigned to true.
            if (hashMap.get(nums[i]) != null) {
                flag = true;
            }

            // The 'put' method inserts the key-value pair into the map if the key does not exist in the map, else it updates the value associated with the key.
            // If the key does not exist in the map, then the corresponding value of the key will be inserted as 'false'
            // If the key exists in the map, then the corresponding value of the key will be updated to 'true' as per above if-condition.
            hashMap.put(nums[i], flag);
        }

        // using loop in the final hash map
        hashMap.forEach((key , value) -> {
            // if the value is true, add the 'keys' (integers) to the ArrayList: duplicate
            if (value) {
                duplicates.add(key);
            }
        });

        return duplicates;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

    }

}

