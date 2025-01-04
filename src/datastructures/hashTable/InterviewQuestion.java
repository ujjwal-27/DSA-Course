package datastructures.hashTable;

import java.util.HashMap;

public class InterviewQuestion {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};

        InterviewQuestion iq = new InterviewQuestion();
        boolean result = iq.commonItem(a1, a2);
        System.out.println(result);
    }

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
