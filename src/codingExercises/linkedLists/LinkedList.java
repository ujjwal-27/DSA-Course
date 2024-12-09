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

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;

        } else {
            tail.next = newNode;
        }

        tail = newNode;
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;
        int i = 0;

        while (i != index) {
            temp = temp.next;
            i++;
        }

        return temp;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public Node getTail() {
        return tail;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);

        } else if (index == length) {
            append(value);

        } else {
            Node newNode = new Node(value);
            Node previous = get(index - 1);
            Node temp = previous.next;

            previous.next = newNode;
            newNode.next = temp;
            length++;
        }

        return true;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
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
        }

        Node before = get(index - 1);
        Node temp = before.next;
        Node after = temp.next;

        temp.next = null; // we don't have to necessarily point it to null because if the 'next pointer' of the 'previous node' points directly to the 'next pointer of current node', then the current node will be removed.
        before.next = after;
        length--;

        return temp;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node previous = head;
        Node temp = head;

        while (temp.next != null) {
            previous = temp;
            temp = temp.next;
        }

        tail = previous;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }

        return temp;
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


