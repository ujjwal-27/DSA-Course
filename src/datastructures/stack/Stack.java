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

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void getTop() {
        System.out.println("Top: " + top.value);
    }

    public void printStack() {
        Node temp = top;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void pull() {
        if (height == 0) {
            return;

        } else if (height == 1) {
            top = null;

        } else {
            Node temp = top;
            top = top.next;
            temp.next = null;
        }

        height--;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (height > 0) {
            newNode.next = top;
        }

        top = newNode;

        height++;
    }
}
