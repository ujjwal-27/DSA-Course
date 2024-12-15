package datastructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.prepend(2);
        doublyLinkedList.prepend(27);
        doublyLinkedList.prepend(22);

        doublyLinkedList.getList();
    }
}
