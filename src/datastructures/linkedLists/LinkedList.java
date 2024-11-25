package datastructures.linkedLists;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;

        } else {
            tail.next = newNode;
        }

        tail = newNode;
        this.length++;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");

        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void getTail() {
        if (tail == null) {
            System.out.println("Tail: null");

        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);

        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void removeLast() {
        if (length == 1) {
            head = null;
            tail = null;
            length = 0;

            System.out.println("List empty: No nodes found.");

        } else {
            Node temp = head;
            Node previous = null;

            while (temp.next != null) {
                previous = temp;
                temp = previous.next;
            }

            tail = previous;
            tail.next = null;

//            System.out.println(temp.value); // check if the value of last node matches or not
        }

        length--;
    }
}
