package interviewQuestions.hashTable.itemInCommon;

import java.util.HashMap;

public class Main {
    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // The second param in the generics which requires value can be of type either boolean or integer.

        for (int i = 0; i < array1.length; i++) {
            hashMap.put(array1[i], 0);
        }

        for (int i = 0; i < array2.length; i++) {
            if (hashMap.get(array2[i]) != null) return true; // Main logic to determine if there is common item between the given arrays or not.
        }

        return false;
    }


    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));

        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */

    }

}
