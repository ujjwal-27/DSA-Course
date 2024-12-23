package interviewQuestions.doublyLinkedList.swapNodesInPairs;

public class DoublyLinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
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
        StringBuilder output = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            output.append(temp.value);
            if (temp.next != null) {
                output.append(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(output.toString());
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
            newNode.prev = current;
        }
        length++;
    }

    public void swapPairs() {
        // Length of list must be >= 2.
        if (length < 2) return;

        // Create a dummy node to simplify swapping process, and to make it easier to point to head node in the end.
        Node dummy = new Node(0);
        dummy.next = head;

        // Create and set a previous node to dummy. Here, the previous node will always be before the two nodes to be swapped.
        Node previous = dummy;

        // Here, the head is also moved
        while (head != null && head.next != null) {
            // In every iteration, the first and second nodes are the ones that are to be swapped.
            Node first = head;
            Node second = head.next;

            // Here, the three main nodes are previous, first and second for completing the swap between two nodes.
            // First, the 'next pointers' of the nodes are adjusted to complete a swap.
            previous.next = second;
            first.next = second.next;
            second.next = first;

            // Since this is DLL, the 'prev pointers' of the nodes must also be adjusted.
            second.prev = previous;
            first.prev = second;

            // first.next was previously second.next node.
            // to complete a swap, we must point the 'prev pointer' of this node to first node.
            if (first.next != null) {
                first.next.prev = first;
            }

            // Then, we adjust the head node and previous node for next iteration
            head = first.next;
            previous = first;
        }

        // After the completion of swap, point the head node to the node next to dummy.
        head = dummy.next;

        // After that, disconnect the dummy node from the list.
        dummy.next.prev = null;
        dummy.next = null;
    }
}


