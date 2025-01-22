package codingExercises.heap.insert;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);

        int currentIndex = heap.size() - 1; // get the index of last element (newly added element)
        int parentIndex = parent(currentIndex); // get the index of parent of last element (newly added element)

        // bubble up the newly added element until it is greater than its parent element, or it reaches the top node.
        while (currentIndex > 0 && value > heap.get(parentIndex)) {
            swap(currentIndex, parentIndex);

            currentIndex = parentIndex; // reassign the value of current index after swap
            parentIndex = parent(currentIndex); // reassign the value of parent index after swap
        }
    }
}







