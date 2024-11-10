package misc.revision.bigO;

public class oOfLogN {
    public static void main(String[] args) {
        int[] a = {5, 7, 10, 15, 29, 27, 3}; // {3, 5, 7, 10, 15, 27, 29}
        int target = 27;
        findItem(a, target);
    }

    public static int[] sortArray(int[] a) {
        boolean flag = true;

        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                flag = false;
            }
        }

        if (!flag) {
            int length = a.length;

            while (length > 0) {
                int element = a[0];

                for (int i = 1; i < length; i++) {
                    if (a[i] < a[i - 1]) {
                        a[i - 1] = a[i];
                        a[i] = element;

                    } else {
                        element = a[i];
                    }
                }

                length--;
            }
        }

        return a;
    }

    public static int binarySearch(int[] a, int target) {
        int[] nums = sortArray(a);

        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) return middle;

            if (nums[middle] > target) {
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
            System.out.println("The index of target value " + target + " is " + result + ".");

        } else {
            System.out.println("The target value " + target + " is not found.");
        }
    }
}
