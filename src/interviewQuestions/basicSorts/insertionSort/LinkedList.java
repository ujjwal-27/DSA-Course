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

    /**
     * In this method, the core logic is first to create a 'sorted list' and 'unsorted list' from the 'original list'.
     * Initially, the 'sorted list' contains only the first element from the 'original list', and rest of the elements from the 'original list' are contained in 'unsorted list'.
     * The 'head' node of sorted list is 'sortedListHead', whereas 'head' node of unsorted list is 'unsortedListHead'.
     * Then, a while-loop is executed on unsorted list until the 'unsortedListHead' is null. (outer loop)
     * Here, a 'currentNode' is created and assigned to 'unsortedListHead', and 'unsortedListHead' is assigned to its 'next node' (unsortedListHead.next).
     * Then, value of 'currentNode' is compared with value of 'sortedListHead'.
     * - IF 'currentNode.value' is smaller than 'sortedListHead.value', then 'currentNode.next' is pointed to 'sortedListHead' and 'sortedListHead' is assigned as 'currentNode'.
     * - ELSE, a 'searchPointer' is created and pointed to 'sortedListHead'.
     * -- A while-loop is executed until 'searchPointer.next' is not null, and 'currentNode.value' is greater than 'searchPointer.next.value'.
     * -- On each iteration of the while-loop, 'searchPointer' is assigned to its 'next node' (searchPointer.next).
     * - After the completion of while-loop, 'next pointer' of 'currentNode' is pointed to next node of 'searchPointer' (currentNode.next = searchPointer.next).
     * - And, 'next pointer' of 'searchPointer' is pointed to 'currentNode'.
     * - This process ensures the elements in the 'sorted list' are in correct and accurate order.
     * Once the 'unsortedListHeader' is null, this marks the complete execution of outer-loop.
     * Then, the 'header' is assigned to the 'sortedListHeader', and a 'temp' node is traversed through the 'sorted list' until it reaches the 'last element'.
     * Then the 'tail' is assigned to the 'last element' of the sorted list.
     * The resulting list will give a sorted list.
     */
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
