package datastructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.append(2);
        doublyLinkedList.append(27);

        System.out.println("---- Before remove last ----");
        doublyLinkedList.getLength();
        doublyLinkedList.getList();

        System.out.println("---- After remove last ----");
        doublyLinkedList.removeLast();
        doublyLinkedList.getLength();
        doublyLinkedList.getList();
    }
}
