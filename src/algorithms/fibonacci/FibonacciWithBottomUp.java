package algorithms.fibonacci;

public class FibonacciWithBottomUp {
    static int counter = 0;

    public static void main(String[] args) {
        int n = 40; // for the value of 40, drastic difference can be observed on counter, with and without using memoization

        System.out.println("Fibonacci no. on " + n + "th position : " + fib(n));
        System.out.println("No. of times method called = " + counter);
    }

    public static int fib(int n) {
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= n; i++) {
            counter++;
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci[n];
    }
}
