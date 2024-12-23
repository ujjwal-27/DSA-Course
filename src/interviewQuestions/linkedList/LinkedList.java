package interviewQuestions.linkedList;

public class LinkedList {
    private Node head;
    private Node tail;

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
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * This method implements hare-tortoise algorithm (Floyd's Tortoise and Hare Algorithm) to find the middle node.
     * Here, two pointers - slow and fast - are initialized, both pointing to the head of the list.
     * While-loop is implemented with the condition stating that the loop shall execute until 'fast' is not null and 'next node of fast' is not null.
     * Inside the code block of while loop, move 'slow' pointer one step ahead, and 'fast' pointer two steps ahead.
     * When the while loop ends, the 'slow' pointer will point to the middle Node of the list.
     * @return Slow pointer
     */
    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) { // fast != null --> for even no. of elements AND fast.next != null --> for odd no. of elements in the list
            slow = slow.next; // one step ahead
            fast = fast.next.next; // two steps ahead
        }

        return slow;
    }

    /**
     * This method implements Floyd's Tortoise and Hare Algorithm to find if the list has loop or not.
     *  Here, two pointers - slow and fast - are initialized, both pointing to the head of the list.
     * While-loop is implemented with the condition stating that the loop shall execute until 'fast' is not null and 'next node of fast' is not null.
     * Inside the code block of while loop, move 'slow' pointer one step ahead, and 'fast' pointer two steps ahead.
     * At a point, if the slow pointer and fast pointer meets, then return true (which means the list has never ending loop)
     * If not, return false.
     * @return Boolean true or false.
     */
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    /**
     * This method use two-pointer technique.
     * Here, the two pointers are initialized as first and second Node.
     * Initially, a for-loop is executed k-times.
     * Within the for-loop, pointer 'first' is checked if it is null or not. If the no. of nodes in the list is less than the value of 'k', the pointer 'first' will reach to a point where it will become null. In that case, return null.
     * On every iteration, the pointer 'first' is moved ahead one-step at a time.
     * Then, a while-loop is executed until pointer 'first' becomes null. Here, within the loop, both 'first' and 'second' pointer is moved ahead one-step at a time. When 'first' pointer becomes null, 'second' pointer reaches kth node from the end.
     * Therefore, second pointer is returned.
     * @param k Integer
     * @return Node on kth place from end.
     */
    public Node findKthFromEnd(int k) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < k; i++) {
            if (first == null) return null;

            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }
}


