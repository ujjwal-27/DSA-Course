package interviewQuestions.linkedList.partitionList;

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
        if (head == null) {
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

    public void partitionList(int x) {
        if (head != null && length != 1) {
            LinkedList highChain = null;
            LinkedList lowChain = null;
            Node highHead = null;
            Node lowHead = null;
            Node lowTail = null;
            Node temp = head;

            while (temp != null) {
                if (temp.value < x) {
                    if (lowHead == null) {
                        lowChain = new LinkedList(temp.value);
                        lowHead = lowChain.getHead();
                        lowTail = lowHead;

                    } else {
                        lowChain.append(temp.value);
                        lowTail = lowTail.next;
                    }

                } else {
                    if (highHead == null) {
                        highChain = new LinkedList(temp.value);
                        highHead = highChain.getHead();

                    } else {
                        highChain.append(temp.value);
                    }
                }

                temp = temp.next;
            }

            assert lowTail != null;
            lowTail.next = highHead;
            head = lowHead;
        }
    }
}


