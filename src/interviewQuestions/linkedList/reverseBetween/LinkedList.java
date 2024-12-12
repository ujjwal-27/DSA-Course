package interviewQuestions.linkedList.reverseBetween;

public class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void reverseBetween(int m, int n) {
        if (head != null) {
            Node dummyNode = new Node(0);
            dummyNode.next = head;
            Node previousNode = dummyNode;

            for (int i = 0; i < m; i++) {
                previousNode = previousNode.next;
            }

            Node currentNode = previousNode.next;

            for (int i = 0; i < n - m; i++) {
                Node nodeToMove = currentNode.next;
                currentNode.next = nodeToMove.next;
                nodeToMove.next = previousNode.next;
                previousNode.next = nodeToMove;
            }

            head = dummyNode.next;
        }
    }
}
