package interviewQuestions.hashTable.groupAnagrams;

import java.util.*;


public class Main {

    public static List<List<String>> groupAnagrams(String[] strings) {
        // This HashMap is used to store anagramsKey as key, and list of anagrams as value.
        // Example:
        // For 1st set - {aet=[eat, tea, ate], abt=[bat], ant=[tan, nat]}
        // For 2nd set - {abr=[bar], abc=[abc, cba, bac], foo=[foo]}
        // For 3rd set - {eilnst=[listen, silent], aegilnrt=[triangle, integral], adegnr=[garden, ranged]}
        HashMap<String, ArrayList<String>> anagramGroups = new HashMap<>();

        // ArrayList to store list of anagram's list.
        List<List<String>> anagramList = new ArrayList<>();

        for (String string: strings) {
            char[] chars = string.toCharArray(); // Converting and storing current string's characters to array
            Arrays.sort(chars); // Sorting array of characters
            String anagramsKey = new String(chars); // Converting sorted array of characters to string. This 'anagramsKey' will be used as 'key' in hash map, and the 'list of its associated string' will be added as 'value'.

            if (anagramGroups.containsKey(anagramsKey)) { // Check if the key already exists in the map.
                anagramGroups.get(anagramsKey).add(string); // If yes, add the 'string' to the 'list of anagrams' associated with the key (anagramsKey).

            } else {
                // If the key doesn't exist, first create a new ArrayList, and add the string to the list.
                // Then, add the key-value pairs of anagramsKey and group (ArrayList) to the map.
                ArrayList<String> group = new ArrayList<>();
                group.add(string);

                anagramGroups.put(anagramsKey, group);
            }
        }

//        System.out.println(anagramGroups); // Check how canonical as key, and list of anagrams as value is stored in the HashMap

        // Populating the values (list of anagrams) from the map to the ArrayList
        anagramGroups.forEach((key, value) -> {
            anagramList.add(value);
        });

        return anagramList;

//        return new ArrayList<>(anagramGroups.values()) // OR directly return this line of code
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
