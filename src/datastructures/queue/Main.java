package datastructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(7);
        queue.enqueue(27);
        queue.enqueue(2);
        queue.enqueue(77);

        queue.getFirst();
        queue.getLast();
        queue.getLength();
        queue.printQueue();
    }
}
