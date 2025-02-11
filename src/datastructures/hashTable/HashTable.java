package datastructures.hashTable;

import java.util.ArrayList;

public class HashTable {
    private int length = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            int ascii = key.charAt(i); // this gives 'ascii value' of the respective 'character' of String 'key'

            // While computing hash value, number is multiplied by 23. Since 23 is a prime number, multiplying any number by 23 has a good chance of getting unique output.
            // Likewise, the resulting value modulus dataMap.length i.e. 7 will give an output between 0 and 6 inclusive, which will determine the address for the input: key.
            hash = (hash + ascii * 23) % dataMap.length;
        }

        return hash;
    }

    public HashTable() {
        dataMap = new Node[length];
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();

        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];

            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }

        return allKeys;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ": ");
            Node temp = dataMap[i]; // Here, this will always point to first Node of the respective index (address).

            while (temp != null) {
                System.out.println("{" + temp.key + " = " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];

        while (temp != null) {
            if (temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }

        return 0;
    }

    public void set(String key, int value) {
        Node newNode = new Node(key, value);
        int index = hash(key);

        if (dataMap[index] == null) {
            dataMap[index] = newNode;

        } else {
            Node temp = dataMap[index]; // Here, this will always point to first Node of the respective index (address).

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }
}
