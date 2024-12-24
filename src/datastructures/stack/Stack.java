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

    public Node pull() {
        if (height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;

        return temp;
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
