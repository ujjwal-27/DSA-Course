package datastructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.append(2);
        doublyLinkedList.append(27);
        doublyLinkedList.append(77);
        doublyLinkedList.append(99);
        doublyLinkedList.append(22);

        System.out.println("---- Before insert ----");
        doublyLinkedList.printList();
        System.out.println("---- After insert ----");
        System.out.println(doublyLinkedList.insert(2, 100));
        System.out.println(doublyLinkedList.insert(5, 53));
        doublyLinkedList.printList();
    }
}
