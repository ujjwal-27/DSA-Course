package misc.recursion;

/**
 * Here, the 'main' method invokes 'methodOne' first.
 * Though the 'methodThree' gets invoked at last, it executes first.
 * This is the concept of call stack which follows LIFO (Last In First Out) principle.
 */
public class CallStack {
    public static void main(String[] args) {
        methodOne();
    }

    /**
     * This method immediately prints out string.
     */
    public static void methodThree() {
        System.out.println("Method 3");
    }

    /**
     * This method invokes 'methodThree' first, and then prints out string.
     */
    public static void methodTwo() {
        methodThree();
        System.out.println("Method 2");
    }

    /**
     * This method invokes 'methodTwo' first, and then prints out string.
     */
    public static void methodOne() {
        methodTwo();
        System.out.println("Method 1");
    }
}
