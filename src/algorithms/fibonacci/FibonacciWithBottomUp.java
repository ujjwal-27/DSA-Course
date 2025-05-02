package algorithms.fibonacci;

public class FibonacciWithBottomUp {
    static int counter = 0; // checks no. of times the method was invoked

    public static void main(String[] args) {
        int n = 40; // for the value of 40, drastic difference can be observed on counter, with and without using memoization

        System.out.println("Fibonacci no. on " + n + "th position : " + fib(n));
        System.out.println("No. of times method called = " + counter);
    }

    /**
     * Using plain recursion, and recursion + memoization are top-down approach.
     * Here, the fibonacci number on the n-th position is computed 'iteratively'. Meaning, loop is involved, and no recursion approach is used.
     * Any dynamic programming done 'iteratively' is known as bottom-up approach.
     *
     * @param n [int] n-th position
     * @return Fibonacci number at n-th position
     */
    public static int fib(int n) {
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        // The loop is executed from index: 2, since index: 0 & 1 are already assigned with values.
        for (int i = 2; i <= n; i++) {
            counter++;

            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]; // adding fibonacci number on current index based on previous two fibonacci numbers.
        }

        return fibonacci[n];
    }
}
