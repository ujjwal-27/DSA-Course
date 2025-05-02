package algorithms.fibonacci;

public class FibonacciWithoutMemoization {
    static int counter = 0; // checks no. of times the method was invoked

    public static void main(String[] args) {
        int n = 40;

        System.out.println("Fibonacci no. on " + n + "th position : " + fib(n)); // output: n-th fibonacci number

        System.out.println("No. of times method called = " + counter); // No. of times the method was invoked through recursion
    }

    /**
     * In this method, the n-th fibonacci number is computed through plain recursion approach.
     * No memoization approach is implemented.
     * Using memoization approach, no. of method calls (counter) can be reduced.
     * Using plain recursion, this method results in Big-O notation of O(n^2).
     * It may not be exactly O(n^2), because not every branch goes to the full depth — it stops at base cases (fib(0) and fib(1))
     * @param n [Integer] n-th position
     * @return Fibonacci of n-th position
     */
    public static int fib(int n) {
        counter++; // counter increment

        if (n == 0 || n == 1) { // base case
            return n;
        }

        return fib(n - 1) + fib(n - 2); // recursion
    }
}
