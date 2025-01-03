package datastructures.hashTable;

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();


        ht.set("programmer", 777);
        ht.set("laptop", 2277);
        ht.set("imac", 2277);
        ht.set("development", 1000);
        ht.set("coding", 100);
        ht.set("java", 1985);

        ht.printTable();
    }
}
