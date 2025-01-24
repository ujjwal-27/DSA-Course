package misc.recursion;

public class CallStack {
    public static void methodThree() {
        System.out.println("Method 3");
    }

    public static void methodTwo() {
        methodThree();
        System.out.println("Method 2");
    }

    public static void methodOne() {
        methodTwo();
        System.out.println("Method 1");
    }

    public static void main(String[] args) {
        methodOne();
    }
}
