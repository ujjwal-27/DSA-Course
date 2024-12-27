package interviewQuestions.stack.arrayList.sort;

public class Main {

    public static void sortStack(Stack<Integer> originalStack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!originalStack.isEmpty()) {
            Integer originalTopElement = originalStack.pop();
            Integer peekSortedStack = sortedStack.peek();

            if (peekSortedStack == null || originalTopElement > peekSortedStack) {
                sortedStack.push(originalTopElement);

            } else {
                while (!sortedStack.isEmpty() && originalTopElement < peekSortedStack) {
                    Integer sortedTopElement = sortedStack.pop();
                    originalStack.push(sortedTopElement);
                }

                sortedStack.push(originalTopElement);
            }
        }

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


