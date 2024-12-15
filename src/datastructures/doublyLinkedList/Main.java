package datastructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);

        System.out.println("---- Before remove last ----");
        doublyLinkedList.getList();

        System.out.println("---- After remove last ----");
        doublyLinkedList.removeLast();
        doublyLinkedList.getList();
    }
}
