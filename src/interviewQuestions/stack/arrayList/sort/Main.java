package interviewQuestions.stack.arrayList.sort;

public class Main {

    public static void sortStack(Stack<Integer> originalStack) {
        Stack<Integer> sortedStack = new Stack<>(); // An empty stack for storing sorted stack temporarily

        // According to the question, top element from original stack is to be removed, and compare it with top element of sorted stack.
        // If the top element of the sorted stack is greater than the current top element of original stack, the top element of the sorted stack should be moved back to the original stack until the current top element from original stack is in the correct position.
        // Following this concept, this outer loop will execute until original stack is empty.
        while (!originalStack.isEmpty()) {
            Integer originalTopElement = originalStack.pop(); // top element from original stack removed, and stored in 'originalTopElement' variable (this is also referred as current element)
            Integer peekSortedStack = sortedStack.peek(); // getting (not removed) top element from sorted stack, and stored in 'peekSortedStack' variable

            // This inner loop will execute until the sorted stack is not empty, and current element is less than top elements of sorted stack from each iteration.
            // If one of the conditions is not satisfied, current element will be pushed to sorted stack.
            while (!sortedStack.isEmpty() && originalTopElement < peekSortedStack) {
                // As long as the condition stated in while statement is true, the top element from sorted stack is removed, and added back to original stack.
                Integer sortedTopElement = sortedStack.pop();
                originalStack.push(sortedTopElement);
                peekSortedStack = sortedStack.peek(); // updating the value of 'peekSortedStack' after executing pop method on sorted stack
            }

            // Once the top element from sorted stack is found which is smaller than current element, it is added to sorted stack
            sortedStack.push(originalTopElement);
        }

        // This loop will execute until sorted stack is empty
        // Here, the top elements from sorted stack is removed, and again added back to original stack.
        while (!sortedStack.isEmpty()) {
            Integer sortedElement = sortedStack.pop();
            originalStack.push(sortedElement);
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

    }

}


