package misc.bigO;

/**
 * Here, we have nested for loop and normal for loop.
 * For n = 10, no. of operations for n = 100 and n^2 = 10000 respectively. This can be implied as O(n^2 + n)
 * As we can see, n^2 is dominant than n when it comes to no. of operations.
 * So, using rule of simplification we drop non-dominant, and we have O(n^2).
 */
public class dropNonDominant {
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

        for (int k = 0; k < n; k++) {
            System.out.println(k);
        }
    }
}
