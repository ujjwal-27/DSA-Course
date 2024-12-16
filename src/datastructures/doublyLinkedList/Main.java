package datastructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.append(2);
        doublyLinkedList.append(27);
        doublyLinkedList.append(77);
        doublyLinkedList.append(99);
        doublyLinkedList.append(22);

        System.out.println(doublyLinkedList.get(6));
        System.out.println(doublyLinkedList.get(5).value);
        System.out.println(doublyLinkedList.get(4).value);
        System.out.println(doublyLinkedList.get(3).value);
        System.out.println(doublyLinkedList.get(2).value);
        System.out.println(doublyLinkedList.get(1).value);
        System.out.println(doublyLinkedList.get(0).value);

        System.out.println("--------------------");
        doublyLinkedList.printList();
    }
}
