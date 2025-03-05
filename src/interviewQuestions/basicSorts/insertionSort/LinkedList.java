package interviewQuestions.basicSorts.insertionSort;

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

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void insertionSort() {
        if (this.length < 2) return;

        Node sortedListHead = this.head;
        Node unsortedListHead = this.head.next;

        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node currentNode = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (currentNode.value < sortedListHead.value) {
                currentNode.next = sortedListHead;
                sortedListHead = currentNode;

            } else {
                Node searchPointer = sortedListHead;

                while (searchPointer.next != null && currentNode.value > searchPointer.next.value) {
                    searchPointer = searchPointer.next;
                }

                currentNode.next = searchPointer.next;
                searchPointer.next = currentNode;
            }
        }

        head = sortedListHead;
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        tail = temp;
    }
}
