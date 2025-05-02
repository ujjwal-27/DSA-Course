package algorithms.fibonacci;

public class FibonacciWithMemoization {
    static int counter = 0;
    static Integer[] memo = new Integer[100];

    public static void main(String[] args) {
        int n = 40; // for the value of 40, drastic difference can be observed on counter, with and without using memoization

        System.out.println("Fibonacci no. on " + n + "th position : " + fib(n));
        System.out.println("No. of times method called = " + counter);
    }

    /**
     * This method uses memoization approach along with recursion.
     * The memoization approach simply stores fibonacci number of n-th position in memo array, ig it doesn't exist.
     * The fibonacci number is stored on the n-th index of array, which can be further reused for the same value of 'n'.
     * Using memoization, it can be observed that the value of counter also decreases.
     * The Big O notation for this can be figured using: (2n - 1).
     * Here, the non-dominant (- 1) and constant (2) can be dropped, which implies Big-O using memoization is O(n).
     *
     * @param n [int] n-th position
     * @return Fibonacci number on n-th position
     */
    public static int fib(int n) {
        counter++; // counter increment

        if (memo[n] != null) { // using the existing fibonacci number from the 'memo' array.
            return memo[n];
        }

        if (n == 0 || n == 1) { // base case
            return n;
        }

        memo[n] = fib(n - 1) + fib(n - 2); // storing the fibonacci number in 'memo' array if it doesn't exist.
        return memo[n];
    }
}
