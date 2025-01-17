package datastructures.heap;

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

    public int leftChild(int index) {
        return (index * 2) + 1;
    }

    public int rightChild(int index) {
        return (index * 2) + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }
}
