package datastructures.doublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
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
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;

        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

        } else {
            temp = tail;

            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void getList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);

        } else if (index == length) {
            append(value);

        } else {
            Node newNode = new Node(value);
            Node temp = get(index);
            Node previous = temp.prev;

            newNode.next = temp;
            newNode.prev = previous;
            previous.next = newNode;
            temp.prev = newNode;
            length++;
        }

        return true;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            tail = newNode;

        } else {
            newNode.next = head;
            head.prev = newNode;
        }

        head = newNode;
        length++;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;

        if (length == 1) {
            head = null;
            tail = null;

        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = tail;

        if (length == 1) {
            head = null;
            tail = null;

        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }

        length--;
        return temp;
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
