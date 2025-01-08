package interviewQuestions.hashTable.setIntroduction;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        setIntro();
    }

    public static void setIntro() {
        HashSet<Integer> s1 = new HashSet<>();

        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);
        s1.add(5);
        System.out.println(s1);

        s1.remove(3);
        System.out.println(s1);

        HashSet<Integer> s2 = new HashSet<>();
        s2.add(3);
        s2.add(4);
        s2.add(5);
        s2.add(6);
        System.out.println(s2);

        System.out.println(s1.containsAll(s2)); // checks if s2 is subset of s1. Meaning, all the element of s2 is contained in s1.

        // Union of two sets
        HashSet<Integer> unionSet = new HashSet<>(s1); // initially assign s1 to unionSet
        System.out.println(unionSet.addAll(s2)); // If all the elements of s2 is already present in union set, the set remains unchanged after addAll() method. So, it will return false in that case.
        System.out.println(unionSet); // returns union of s1 and s2 (all the values from both HashSet)

        // Intersection of two sets
        HashSet<Integer> intersectionSet = new HashSet<>(s1); // initially assign s1 to intersectionSet
        System.out.println(intersectionSet.retainAll(s2)); // returns boolean
        System.out.println(intersectionSet); // returns intersection of s1 and s2 (common values from both the HashSet)

        // Difference of two sets
        HashSet<Integer> differenceSet = new HashSet<>(s1); // initially assign s1 to differenceSet
        System.out.println(differenceSet.removeAll(s2)); // If none of the elements of s2 is present in union set, the set remains unchanged after removeAll() method. So, it will return false in that case.
        System.out.println(differenceSet); // returns the set of values which are found in s1 only, but not in s2

        if (s1.contains(2)) {
            System.out.println("Found.");

        } else {
            System.out.println("Not found.");
        }
    }
}
