package codingExercises.heap.minHeap.insert;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
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

        int currentIndex = heap.size() - 1;
        int parentIndex = parent(currentIndex);

        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parentIndex)) {
            swap(currentIndex, parentIndex);

            currentIndex = parentIndex;
            parentIndex = parent(currentIndex);
        }
    }

}

