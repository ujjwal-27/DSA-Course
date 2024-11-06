package bigO;

public class oOfLogN {
    public static void main(String[] args) {
        int[] a = {5, 7, 10, 15, 22, 27, 36};
        int target = 27;
        findItem(a, target);
    }

    public static int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int middle = (right - left) / 2 + left;

            if (a[middle] == target) return middle;

            if (a[middle] > target) {
                right = middle - 1;

            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static void findItem(int[] a, int target) {
        int result = binarySearch(a, target);

        if (result != -1) {
            System.out.println("The index of targeted value " + target + " is " + result + ".");

        } else {
            System.out.println("The targeted value " + target + " is not present.");
        }
    }
}
