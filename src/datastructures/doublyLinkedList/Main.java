package datastructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.append(2);
        doublyLinkedList.append(27);
        doublyLinkedList.append(99);

        System.out.println("---- Before remove first ----");
        doublyLinkedList.getLength();
        doublyLinkedList.getList();

        System.out.println("---- After remove first ----");
        System.out.println("Removed: " + doublyLinkedList.removeFirst().value);
        System.out.println("Removed: " + doublyLinkedList.removeFirst().value);
        doublyLinkedList.getLength();
        doublyLinkedList.getList();
    }
}
