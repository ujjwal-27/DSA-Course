package datastructures.heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.insert(99);
        heap.insert(75);
        heap.insert(82);
        heap.insert(22);
        heap.insert(100);
        heap.insert(91);

        System.out.println(heap.getHeap());
    }
}
