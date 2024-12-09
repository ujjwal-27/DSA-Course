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

    public void partitionList_self(int x) {
        if (head != null && length != 1) {
            LinkedList highChain = null; // a new linked list for holding values >= x
            LinkedList lowChain = null; // a new linked list for holding values < x
            Node highHead = null; // head pointer for 'highChain' list
            Node lowHead = null; // head pointer for 'lowChain' list
            Node lowTail = null; // tail pointer for 'lowChain' list
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

            lowTail.next = highHead;
            head = lowHead;
        }
    }

    public void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;

            } else {
                prev2.next = current;
                prev2 = current;
            }

            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }
}


