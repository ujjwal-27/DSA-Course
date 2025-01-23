package interviewQuestions.heap.kthSmallElementInArray;

public class Main {

    /**
     * In this method, each element from 'nums' array is inserted to heap object.
     * A for-loop is executed on 'nums' array for inserting the numbers in heap:
     * - Upon inserting, the size of the heap is checked. If the size of heap reaches greater than 'k', the inserted element is immediately removed.
     * - After the completion of loop, there remains k-number of elements in heap.
     * - The top element will be the kth-smallest element in the heap. (For every test cases below, this pattern matches)
     * Finally, from the resulting heap, the top element is removed and returned.
     * @param nums Arrays of integers
     * @param k [Integer]
     * @return [Integer] kth-smallest element in the heap
     */
    public static int findKthSmallest(int[] nums, int k) {
        Heap maxHeap = new Heap();

        for (int num: nums) {
            maxHeap.insert(num);
//            System.out.println("Before remove:" + maxHeap.getHeap()); // To track the elements in heap before remove.

            // This if-block is executed as soon as the size of heap is greater than 'k'.
            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
//                System.out.println("After remove: " + maxHeap.getHeap()); // To track the elements in heap before remove.
            }
        }

        return maxHeap.remove(); // returns the kth element.
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
        System.out.println();

        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
        System.out.println();


        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1:
            Expected output: 7
            Actual output: 7

            Test case 2:
            Expected output: 2
            Actual output: 2

            Test case 3:
            Expected output: 7
            Actual output: 7

        */

    }

}



