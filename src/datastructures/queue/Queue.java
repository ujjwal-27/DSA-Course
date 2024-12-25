package datastructures.queue;

public class Queue {
    Node first;
    Node last;
    int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);

        first = newNode;
        last = newNode;
        length = 1;
    }
}
