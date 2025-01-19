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
     * This method swap the value of two nodes with the help of index.
     * @param index1 [Integer] Index of a node
     * @param index2 [Integer] Index of a node
     */
    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
