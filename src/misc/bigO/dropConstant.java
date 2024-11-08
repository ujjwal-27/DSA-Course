package bigO;

/**
 * Here we have n = 10, and no. of operations = 20 (since there are two for-loops)
 * This might look like O(2n) since n + n = 2n
 * Using rule of simplification we can drop the constant '2' and we have O(n).
 */
public class dropConstant {
    public static void main(String[] args) {
        printItems(10);
    }

    public static void printItems(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < n; j++) {
            System.out.println(j);
        }
    }
}
