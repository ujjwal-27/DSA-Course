package datastructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.append(2);
        doublyLinkedList.append(27);
        doublyLinkedList.append(77);

        System.out.println("---- Before remove ----");
        doublyLinkedList.printList();
        System.out.println("---- After remove ----");
        System.out.println("Removed: " + doublyLinkedList.remove(2).value);
        doublyLinkedList.printList();
    }
}
