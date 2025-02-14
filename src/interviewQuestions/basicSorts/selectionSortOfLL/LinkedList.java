package interviewQuestions.basicSorts.selectionSortOfLL;

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

    public void selectionSort() {
        if (this.length < 2) return;

        Node toSwap = this.head;

        while (toSwap.next != null) {
            Node currentNode = toSwap.next;
            Node minNode = toSwap;

            while (currentNode != null) {
                if (currentNode.value < minNode.value) {
                    minNode = currentNode;
                }

                currentNode = currentNode.next;
            }

            if (minNode != toSwap) {
                int temp = toSwap.value;
                toSwap.value = minNode.value;
                minNode.value = temp;
            }

            toSwap = toSwap.next;
        }
    }

}
