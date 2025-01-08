package interviewQuestions.hashTable.setHasUniqueChars;
import java.util.HashSet;
import java.util.Set;


public class Main {

    /**
     * In this method, first an empty HashSet is created.
     * Then, every character from the string is added to the set.
     * Lastly, the length of string and charSet is compared. If it's equal then all the characters in the string is unique, else not.
     * @param string Random string
     * @return Boolean true/false
     */
    public static boolean hasUniqueChars(String string) {
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            charSet.add(string.charAt(i));
        }

        return (string.length() == charSet.size());
    }


    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcdefg")); // should return true
        System.out.println(hasUniqueChars("hello")); // should return false
        System.out.println(hasUniqueChars("")); // should return true
        System.out.println(hasUniqueChars("0123456789")); // should return true
        System.out.println(hasUniqueChars("abacadaeaf")); // should return false

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
            true
            false

        */

    }

}

