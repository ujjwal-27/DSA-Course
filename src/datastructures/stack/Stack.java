package datastructures.stack;

public class Stack {
    Node top;
    int height;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);

        top = newNode;
        height = 1;
    }
}
