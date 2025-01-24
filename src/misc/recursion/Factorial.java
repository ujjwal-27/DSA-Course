package misc.recursion;

public class Factorial {
    public static void main(String[] args) {
        int result = getFactorial(4);
        System.out.println(result);
    }

    /**
     * Here, the factorial of 'n' is computed using recursion concept.
     * @param n An integer
     * @return [Integer] Factorial of 'n'
     */
    public static int getFactorial(int n) {
        if (n == 1) return 1; // base case

        return n * getFactorial(n - 1); // recursive case
    }
}
