package codingExercises.linkedLists;

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


    //   +===================================================+
    //   |                  WRITE YOUR CODE HERE             |
    //   | Description:                                      |
    //   | - Constructor for the LinkedList class.           |
    //   | - Initializes the linked list with a single node. |
    //   |                                                   |
    //   | Parameters:                                       |
    //   | - value: The integer value of the first node in   |
    //   |   the newly created linked list.                  |
    //   |                                                   |
    //   | Behavior:                                         |
    //   | - A new Node is created with the given value.     |
    //   | - This node is set as both the head and tail of   |
    //   |   the list, indicating it is the only node in the |
    //   |   list at creation.                               |
    //   | - The length of the list is initialized to 1.     |
    //   +===================================================+


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
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
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

}

