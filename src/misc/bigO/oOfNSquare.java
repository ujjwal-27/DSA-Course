package misc.bigO;

/**
 * Here, we have n = 10, and no of operations = n * n = n^2
 * Hence, it is referred as O(n^2).
 */
public class oOfNSquare {
    public static void main(String[] args) {
        printItems(10);
    }

    public static void printItems(int n) {
        // nested for loop
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }
    }
}
