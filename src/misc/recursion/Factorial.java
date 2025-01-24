package misc.recursion;

public class Factorial {
    public static void main(String[] args) {
        int result = getFactorial(4);
        System.out.println(result);
    }

    public static int getFactorial(int n) {
        if (n == 1) return 1;

        return n * getFactorial(n - 1);
    }
}
