package interviewQuestions.hashTable.firstNonRepeatingCharacter;

import java.util.*;


public class Main {

    public static Character firstNonRepeatingChar(String string) {
        HashMap<Character, Integer> charCounts = new HashMap<>();

        for (char i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            // 'charCounts.getOrDefault(character, 0)' --> This code either gives the actual value of associated with key (character) from the map, or gives zero if the key does not exist.
            charCounts.put(character, charCounts.getOrDefault(character, 0) + 1); // + 1 to increase the count of associated key (character) on each encounter.
        }

        // Iterating through the 'input string' again to check the occurrence count of characters in sequence.
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
