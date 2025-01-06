package interviewQuestions.hashTable.groupAnagrams;

import java.util.*;


public class Main {

    public static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, Boolean> anagramGroups = new HashMap<>();
        List<List<String>> arrayList = new ArrayList<>(); // dummy array list to return something in the end to avoid error

        for (String string: strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);

            String canonical = new String(chars);
            System.out.println(canonical);
        }

        return arrayList;
    }


    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */

    }

}
