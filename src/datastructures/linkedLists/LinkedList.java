package datastructures.linkedLists;

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

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {  // edge case
            head = newNode;

        } else {
            tail.next = newNode;
        }

        tail = newNode;
        this.length++;
    }

    /**
     * This method returns the value of particular index provided in the parameter.
     * @param index Integer
     * @return Integer value of provided index
     */
    public Node get(int index) {
        if (index < 0 || index >= length) return null; // edge case

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * This method returns true or false depending on whether the value passed through parameter is available in the list or not.
     * @param value Integer
     * @return Boolean
     */
    public boolean getByValue(int value) {
        if (length == 0) return false;

        Node temp = head;

        while (temp != null) {
            if (temp.value == value) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");

        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void getTail() {
        if (tail == null) {
            System.out.println("Tail: null");

        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            
        } else if (index == length) {
            append(value);

        } else {
            Node newNode = new Node(value);
            Node temp = get(index - 1);

            newNode.next = temp.next;
            temp.next = newNode;

            length++;
        }

        return true;
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);

        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;

        } else {
            newNode.next = head;
            head = newNode;
        }

        length++;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) {
            return removeFirst();

        } else if (index == length - 1) {
            return removeLast();

        } else {
            Node previous = get(index - 1);
            Node temp = previous.next; // Instead of invoking get(index) method for temp variable which use O(n), we can simply use 'previous.next' which gives the same value and also contributes in optimizing operation time.

            previous.next = temp.next;
            temp.next = null;

            length--;

            return temp;
        }
    }

    public Node removeFirst() {
        if (length == 0) return null; // edge case

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) { // edge case
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeLast() {
        if (length == 0) return null; // edge case

        Node temp = head;
        Node previous = head;

        while (temp.next != null) {
            previous = temp;
            temp = temp.next; // can also use 'previous.next'
        }

        tail = previous;
        tail.next = null;
        length--;

        if (length == 0) { // edge case
            head = null;
            tail = null;
        }

        return temp; // returns the node that was removed while this method was invoked
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = null;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }
}
