package interviewQuestions.basicSorts.bubbleSortOfLL;

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

    /**
     * This method implements 'bubble sort' approach to sort linked list. Hence, a nested loop will be implemented.
     * Initially, a node variable 'sortedUntil' is assigned to 'null' (i.e. at the every end of the list)
     * An outer while-loop is executed until the 'sortedUntil' is not equal to 'second node' of the list i.e. 'head.next'.
     * - Within this outer loop, a node variable 'currentNode' is assigned with 'head' node.
     * - Then, an inner while-loop is executed until 'currentNode.next' does not reach 'sortedUntil'.
     * -- Within this inner loop, the value of 'currentNode' is compared with the value of the node 'next' to it (i.e. currentNode.next).
     * -- If value of 'currentNode' is greater, 'swap' the values between the two nodes.
     * -- After the completion of each iteration of inner loop, shift 'currentNode' to the node 'next' to it (currentNode.next).
     * -- This is how it will be determined whether the 'currentNode.next' has reached 'sortedUntil' or not.
     * -- Once the condition is satisfied, the inner loop is completed.
     * - After the complete execution of inner loop, 'sortedUntil' node is assigned to the node 'before' it (i.e. currentNode).
     * - This is how it will be determined whether the 'sortedUntil' has reached 'head.next' or not.
     */
    public void bubbleSort() {
        if (this.length < 2) return;

        Node sortedUntil = this.tail.next;

        while (sortedUntil != this.head.next) {
            Node currentNode = this.head;

            while (currentNode.next != sortedUntil) {
                if (currentNode.value > currentNode.next.value) {
                    int temp = currentNode.value;
                    currentNode.value = currentNode.next.value;
                    currentNode.next.value = temp;
                }

                currentNode = currentNode.next;
            }

            sortedUntil = currentNode;
        }
    }

}
