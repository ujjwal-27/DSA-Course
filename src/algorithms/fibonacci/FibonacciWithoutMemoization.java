package algorithms.fibonacci;

public class FibonacciWithoutMemoization {
    static int counter = 0; // 'counter' to check no. of times the method was invoked

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Fibonacci no. on " + n + "th position : " + fib(n)); // output: n-th fibonacci number

        System.out.println("No. of times method called = " + counter); // No. of times the method was invoked through recursion
    }

    /**
     * In this method, the n-th fibonacci number is computed through plain recursion approach.
     * No memoization approach is implemented.
     * Using memoization approach, no. of method calls (counter) can be reduced.
     * Using plain recursion, this method results in Big O notation of O(n^2).
     * @param n [Integer] n-th position
     * @return Fibonacci of n-th position
     */
    public static int fib(int n) {
        counter++;

        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2); // recursion + base case
    }
}
