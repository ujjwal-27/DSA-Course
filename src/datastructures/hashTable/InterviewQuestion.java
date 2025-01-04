package datastructures.hashTable;

import java.util.HashMap;

public class InterviewQuestion {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};

        InterviewQuestion iq = new InterviewQuestion();
        boolean result = iq.checkCommonItem(a1, a2);
        System.out.println(result);
    }

    /**
     * There are two ways of checking whether two arrays have common items or not.
     * One approach would be using nested for-loop which would result in O(n^2) - worst case.
     * Another approach is implemented in this method below, which is by using hash map. This approach results in O(2n) i.e. O(n) - average case.
     * @param a1 Array of integers
     * @param a2 Array of integers
     * @return Boolean true/false
     */
    public boolean checkCommonItem(int[] a1, int[] a2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for (int i = 0; i < a1.length; i++) {
            hashMap.put(a1[i], true);
        }

        for (int i = 0; i < a2.length; i++) {
            if (hashMap.get(a2[i]) != null) return true;
        }

        return false;
    }
}
