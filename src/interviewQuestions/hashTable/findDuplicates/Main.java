package interviewQuestions.hashTable.findDuplicates;

import java.util.*;


public class Main {

    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;

            if (hashMap.get(nums[i]) != null) {
                flag = true;
            }

            hashMap.put(nums[i], flag);
        }

        hashMap.forEach((key , value) -> {
            if (value) {
                duplicates.add(key);
            }
        });

        return duplicates;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

    }

}

