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

    /**
     * This method reverses the nodes of the list between indexes m and n (inclusive).
     * This list does not have a tail node.
     * @param m Start index
     * @param n End index
     */
    public void reverseBetween(int m, int n) {
        if (head != null) { // first check if the list is empty or not
            Node dummyNode = new Node(0); // this node helps to simplify the logic, if we have to reverse from the first node. Later, it helps to exactly assign head pointer.
            dummyNode.next = head;

            // For the core reverse logic, three nodes will be mainly involved, with first one being 'previousNode'.
            Node previousNode = dummyNode;

            // assign previousNode right before the start of reverse segment (before m)
            for (int i = 0; i < m; i++) {
                previousNode = previousNode.next;
            }

            // Among three nodes, another one is 'currentNode', which will be assigned next to 'previousNode'.
            Node currentNode = previousNode.next;

            // Core logic for implementing reverse functionality. This loop will be executed (n - m) times.
            for (int i = 0; i < n - m; i++) {
                Node nodeToMove = currentNode.next; // Among three nodes, 'nodeToMove' is another node involved which will be placed next to 'currentNode'.
                currentNode.next = nodeToMove.next; // First, assign 'next pointer of currentNode' to the node next to 'nodeToMove'
                nodeToMove.next = previousNode.next; // Then, assign 'next pointer of nodeToMove' to the node next to 'previousNode'
                previousNode.next = nodeToMove; // Then, assign 'next pointer of previousNode' to 'nodeToMove' node
            }

            head = dummyNode.next; // Finally, assign 'head' with node 'next to dummyNode'
        }
    }
}
