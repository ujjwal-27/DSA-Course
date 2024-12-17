package datastructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.append(2);
        doublyLinkedList.append(27);
        doublyLinkedList.append(77);

        System.out.println("---- Before insert ----");
        doublyLinkedList.printList();
        System.out.println("---- After insert ----");
        System.out.println(doublyLinkedList.insert(0, 100));
        System.out.println(doublyLinkedList.insert(4, 53));
        doublyLinkedList.printList();
    }
}
