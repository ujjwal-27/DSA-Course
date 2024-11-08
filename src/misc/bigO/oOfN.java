package misc.bigO;

/**
 * Here, we have n = 10, and no. of operation = 10
 * Simply, it's O(n)/
 */
public class oOfN {
    public static void main(String[] args) {
        printItems(10);
    }

    public static void printItems(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }
}
