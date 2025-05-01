package algorithms.fibonacci;

public class FibonacciWithoutMemoization {
    static  int counter = 0;

    public static void main(String[] args) {
        int n = 7;

        System.out.println("Fibonacci no. on " + n + "th position : " + fib(n));

        System.out.println("No. of times method called = " + counter);
    }

    public static int fib(int n) {
        counter++;

        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
