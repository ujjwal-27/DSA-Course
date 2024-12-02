package datastructures.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Intro {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        arrayList.add(5);
        arrayList.add(25);
        arrayList.add(72);
        arrayList.add(99);

        linkedList.add(5);
        linkedList.add(25);
        linkedList.add(72);
        linkedList.add(99);

        System.out.println(arrayList);
        System.out.println(linkedList);

        System.out.println(arrayList.get(2));
        System.out.println(linkedList.get(2));
    }
}
