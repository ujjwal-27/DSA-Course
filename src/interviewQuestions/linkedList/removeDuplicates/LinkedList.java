package interviewQuestions.linkedList.removeDuplicates;

import java.util.HashSet;
import java.util.Set;

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

//    public void removeDuplicates() {
//        Node current = head;
//
//        while (current != null) {
//            Node runner = current;
//
//            while (runner.next != null) {
//
//                if (runner.next.value == current.value) {
//                    // Here, if the value of current node and value of next pointer of runner node is equal (duplicate value found), then we skip the duplicate value by setting runner.next to runner.next.next
//                    runner.next = runner.next.next;
//                    length --; // once a node is skipped (technically removed), then the length of the list must also be decreased by 1.
//
//                } else {
//                    runner = runner.next;
//                }
//            }
//
//            current = current.next;
//        }
//    }

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();

        Node current = head;
        Node prev = null; // here, this 'prev' pointer acts as the duplicate node remover by skipping the current node if found duplicate.

        while (current != null) {
            if (values.contains(current.value)) {
                prev.next = current.next; // the 'next' pointer of 'prev' node skips the 'current' node and points to node next to current.
                length--;

            } else {
                values.add(current.value);
                prev = current;
            }

            current = current.next;
        }
    }
}


