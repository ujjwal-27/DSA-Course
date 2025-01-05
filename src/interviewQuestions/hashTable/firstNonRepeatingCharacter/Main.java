package interviewQuestions.hashTable.firstNonRepeatingCharacter;

import java.util.*;


public class Main {

    public static Character firstNonRepeatingChar(String string) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            hashMap.put(string.charAt(i), hashMap.getOrDefault(string.charAt(i), 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            if (hashMap.get(string.charAt(i)) == 1) {
                return string.charAt(i);
            }
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

    }

}
