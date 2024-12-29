package interviewQuestions.stackAndQueue.enqueue;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * In this method, two stacks are used to add integer values in the queue while maintaining FIFO order of the elements.
     * Here, stack1 is the main stack object where we need to insert values, and create a queue in the end whereas we use stack2 to temporarily store the value in order to arrange the values in stack1 as required.
     * For this, we'll pop all the values from stack1 until it is empty, and push it to stack2. Doing this, we are emptying stack1.
     * Then, we push the new value into empty stack1.
     * After that, we pop and push the values from stack2 to stack1, one after another until stack2 is empty.
     * @param value Integer
     */
    public void enqueue(int value) {
        while (!isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

