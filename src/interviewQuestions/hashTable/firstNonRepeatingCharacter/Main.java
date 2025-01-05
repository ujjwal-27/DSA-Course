package interviewQuestions.hashTable.firstNonRepeatingCharacter;

import java.util.*;


public class Main {

    public static Character firstNonRepeatingChar(String string) {
        HashMap<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            // 'charCounts.getOrDefault(string.charAt(i), 0)' --> This code either gives the actual value of associated with key (string.charAt(i)) from the map, or gives zero if the key does not exist.
            charCounts.put(string.charAt(i), charCounts.getOrDefault(string.charAt(i), 0) + 1); // + 1 to increase the count of associated key (character) on each encounter.
        }

        // iterating through the input string again to check the occurrence count in sequence.
        for (int i = 0; i < string.length(); i++) {
            // As soon as the character with count 1 is found, return the respective character.
            if (charCounts.get(string.charAt(i)) == 1) {
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
