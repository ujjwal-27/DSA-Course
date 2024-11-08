package bigO;

/**
 * The concept of O(log n) time complexity is to find a specified element in an array by cutting the array into halves until the targeted value is found.
 * The array has to be sorted for this.
 * Initially, the middle element is checked, and if it is equal to our targeted value, then we're done.
 * Else if the middle element is greater than targeted value, then we shift to the left half.
 * Or if the middle element is smaller than targeted value, then we shift to the right half.
 * And continue the procedure.
 * Here, I have implemented extra step of sorting the array in ascending order if it is not.
 */
public class oOfLogN {
    public static void main(String[] args) {
        int[] a = {5, 7, 10, 15, 29, 27, 3};
        int target = 29;
        findItem(a, target);
    }

    /**
     * Here, the array is checked if it in ascending order or not. If not, it is sorted accordingly.
     * @param a Array of integers
     * @return a Array of integers
     */
    public static int[] sortArray(int[] a) {
        boolean ascendingFlag = true;

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                ascendingFlag = false;
                break;
            }
        }

        if (!ascendingFlag) {
            int length = a.length;

            while (length > 0) {
                int element = a[0];

                for (int i = 1; i < length; i++) {
                    if (a[i] < element) {
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

    public static int binarySearch(int[] arr, int target) {
        int[] a = sortArray(arr);

        int left = 0; // very left end of the array
        int right = a.length - 1; // very right end of the array

        while (left <= right) {
            int middle = (right - left) / 2 + left; // getting the middle element

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
