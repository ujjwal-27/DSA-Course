package datastructures.hashTable;

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();

//        ht.printTable();
        System.out.println(ht.hash("programmer"));
        System.out.println(ht.hash("computer"));
        System.out.println(ht.hash("laptop"));
    }
}
