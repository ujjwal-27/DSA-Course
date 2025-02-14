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

    /**
     * This method follows 'section sort' approach to sort linked list. Hence, a nested loop will be implemented.
     * Here, the core concept is, on each iteration of outer loop, a node is picked in sequence starting from 'head' node (toSwap), and swap it with the 'smallest' node (minNode) in the list.
     * The process of determining smallest node (minNode) is carried out inside inner loop. And once the iteration of inner loop is completed, swapping is done between the 'smallest' node (minNode) and node picked to be swapped (toSwap).
     * ----------------------------------------------------------------------------------------------------------------------
     * Implementation:
     * Initially, a node variable named 'toSwap' is assigned to node 'head'.
     * Then, an outer while loop is executed until the 'node' next to 'toSwap' (toSwap.next) is not 'null'.
     * - Within the outer loop, a node variable named 'currentNode' is assigned next to 'toSwap' node (toSwap.next).
     * - Likewise, a node variable named 'minNode' is assigned to 'toSwap'.
     * - Then, an inner loop is executed until 'currentNode' is not equals to null.
     * -- Within the inner loop, the value of 'currentNode' is compared with value of 'minNode'.
     * -- If value of 'currentNode' is smaller, then 'currentNode' is assigned to 'minNode'.
     * -- Then, the 'currentNode' is shifted to the 'node' next to it (currentNode.next).
     * -- This is how it will be determined if the 'currentNode' has reached to the 'null' point.
     * - Then, after the complete execution of inner loop, check if the nodes 'minNode' and 'toSwap' are equal or not.
     * - If not, swap the values between 'minNode' and 'toSwap'.
     * - Then, the 'toSwap' node is shifted to the 'node' next to it (toSwap.next).
     * - This is how it will be determined if the 'node' next to 'toSwap' (toSwap.next) is 'null' or not.
     */
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
