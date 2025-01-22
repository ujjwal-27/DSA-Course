package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * In Heap, the values (Nodes) are stored in list of integer.
 * There are basically two ways of storing Heap: 0-based indexing or 1-based indexing.
 * Here, we'll be using 0-based indexing approach. Meaning, the values will be added to list starting from 0 index.
 */
public class Heap {
    // declare instance variable 'heap' of type integer list.
    private List<Integer> heap;

    /**
     * Heap constructor: Initializing an ArrayList object for 'heap' reference variable.
     */
    public Heap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Here, the instance variable 'heap' is passed through the new ArrayList object.
     * The newly created ArrayList 'heap' is then returned. Meaning, a copy of existing heap is returned.
     * This is done to prevent anyone to access original heap and make changes to the values. Basically, this allows to maintain the validity of original heap.
     * @return ArrayList
     */
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    /**
     * In this method, the new value is first added to the list.
     * Then, the 'index' of newly added value is stored in 'current' variable.
     * Then, a while-loop is executed until the value of 'current' (index of new value) is not zero, and until the 'newly added value' is greater than the 'value of its parent'.
     * - In each iteration, 'index' of 'new value' (current) is swapped with the 'index' of its 'parent'.
     * - And then, 'current' is assigned with 'index' of its 'parent'.
     * - In next iteration, 'current' will have new parent.
     * The while-loop holds the core logic for inserting new value in heap, while maintaining its validity.
     * @param value [Integer]
     */
    public void insert(int value) {
        heap.add(value);

        int current = heap.size() - 1; // initialize 'current' with the 'last index' of the 'list' which indicates the 'index' of 'newly added value'.

        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**
     * This method returns the index of left-child node of the parent node.
     * @param index [Integer] Index of parent node
     * @return [Integer] Index of left-child.
     */
    public int leftChild(int index) {
        return (index * 2) + 1;
    }

    /**
     * This method returns the index of right-child node of the parent node.
     * @param index [Integer] Index of parent node
     * @return [Integer] Index of right-child.
     */
    public int rightChild(int index) {
        return (index * 2) + 2;
    }

    /**
     * This method returns the index of parent node of the child node.
     * @param index [Integer] Index of child-node
     * @return [Integer] Index of parent.
     */
    public int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Edge cases:
     * 1. Check if heap is empty. If yes, return null.
     * 2. Check if the size of is 1. If yes, remove and return the only value from the heap.
     * ------------------------------------------------------------------------------------------
     * Implementations (if the size of heap is greater than 1):
     * Firstly, this method simply replaces the 'value at 0-index' (top node) with the 'value at last index' (last node) of the heap.
     * Then, 'sinkDown' method is invoked by passing the 0 index as argument, to maintain a valid heap.
     * In this method, the value of 'last node' which replaced the 'top node' is compared with its left child and right child, and swapped with the child with the greatest value.
     * This is done, until the node is greater than its both left and right child.
     * @return [Integer] Top value of the Heap.
     */
    public Integer remove() {
        if (heap.isEmpty()) return null;

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int topValue = heap.get(0); // top node
        int lastValue = heap.remove(heap.size() - 1); // last node
        heap.set(0, lastValue); // setting the last node in 0-index

        sinkDown(0);

        return topValue;
    }

    /**
     * In this method, the 'value of node' which is at '0-index' is compared with its 'left child' and 'right child'. Then, it is swapped with the 'one of the children' with the 'greatest value'.
     * This is done, until the value of that 'node' is greater than its 'both left and right child'.
     * Implementations:
     * - First, a variable 'maxIndex' is assigned with 'index' from parameter.
     * - The variable 'maxIndex' will later be updated accordingly, if the value of either 'left child' or 'right child' is comparatively 'greater'.
     * - A 'while-loop' is executed with 'condition set to true'.
     * --
     * @param index Initially, the value of 'index' will always be 0.
     */
    private void sinkDown(int index) {
        int maxIndex = index;
        int heapSize = heap.size();

        while (true) {
            int leftIndex = leftChild(index); // This method simply provide the index of 'left child'. The resulting index (leftIndex) may or may not exist in the heap.
            int rightIndex = rightChild(index); // This method simply provide the index of 'right child'. The resulting index (rightIndex) may or may not exist in the heap.

            // Here, the condition 'leftIndex < heapSize' validates the existence of leftIndex.
            // Meaning, if the 'total size of heap' is 7, then the 'index of last node/element' of the heap will be 6.
            // So, if the 'leftIndex' is less than 'heap size', the condition is true.
            // Also, the second condition checks if the 'value of leftIndex' is greater than the 'value of maxIndex'.
            // Here, the 'maxIndex' is the 'index of parent'.
            if (leftIndex < heapSize && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex; // If yes, then leftIndex is set as maxIndex
            }

            // Same logic for 'rightIndex < heapSize'.
            // Likewise, the second condition checks if the 'value of rightIndex' is greater than the 'value of maxIndex'.
            // Here, the 'maxIndex' is either 'leftIndex' or the 'index of parent'.
            if (rightIndex < heapSize && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex; // If yes, then 'rightIndex' is set as 'maxIndex'
            }

            // The variable 'index' always represents the 'index of initial top-most node' of heap.
            // If (index != maxIndex) means either 'leftIndex' or 'rightIndex' is assigned as 'maxIndex'.
            if (index != maxIndex) {
                swap(index, maxIndex);
                index = maxIndex; // After the swap, reassign 'index' with the 'maxIndex'. This will allow to get the accurate leftIndex and rightIndex in next iteration.

            } else {
                return;
            }
        }
    }

    /**
     * This method swap the 'value of two nodes' with the help of 'index'.
     * @param index1 [Integer] Index of a node
     * @param index2 [Integer] Index of a node
     */
    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
