package datastructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(7);
        stack.push(22);
        stack.push(89);

        stack.getHeight();
        stack.getTop();
        stack.printStack();
    }
}
