package interviewQuestions.basicSorts.mergeSort;

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

    public void merge(LinkedList otherList) {
        Node otherHead = otherList.getHead(); // Storing head of 'otherList' in new variable 'otherHead'. It will be used to traverse through the otherList.
        Node dummy = new Node(0); // Creating new 'dummy' node of value '0'.
        dummy.next = this.head; // Placing 'dummy' node at the beginning of the list.
        Node current = dummy; // Assigning 'current' node to 'dummy'.

        // This while-loop will execute while current.next is not null, and otherHead is not null.
        // The loop will break if one of them is null.
        while (current.next != null && otherHead != null) {
            if (current.next.value < otherHead.value) {
                System.out.println("here");
                current = current.next; // Move forward in this list

            } else {
                /*
                 * BUG
                 * linkedList: 0 -> 1 -> 3 -> 5
                 * otherList: 2 -> 4
                 * Here, when we assign otherHead to current.next (1 -> 2), the otherHead will be pointing to Node 2 in the original list instead of otherList.
                 * This completely wrecks the code. The otherHead must always be part of otherList.
                 * So, logic must be implemented in which the otherHead always remains in otherList.
                 */
//                Node temp = current.next;
//                current.next = otherHead;
//                System.out.println(otherHead.next.value); // BUG
//                current = current.next;
//                current.next = temp;
//                otherHead = otherHead.next;

                // Resolved (CRUCIAL PART OF THIS LOGIC)
                // Always remember that, when we move a node from one list to another list, we are moving its pointer too.
                Node temp = otherHead;
                otherHead = otherHead.next;
                temp.next = current.next;
                current.next = temp;

                this.length++;
            }
        }

        // If any elements remain in otherList, append them
        while (current.next == null && otherHead != null) {
            current.next = otherHead;
            current = current.next;
            otherHead = otherHead.next;
            this.length++;
        }

        // If there is no element in 'otherList', but the 'current.next' still points to another node (not null), move the 'current' pointer forward
        // This logic makes sure that the 'current' is pointing the last node of the merged list.
        // This makes updating of 'tail' efficient.
        while (otherHead == null && current.next != null) {
            current = current.next;
        }

        // Update head and tail
        this.head = dummy.next;
        this.tail = current;
    }
}



