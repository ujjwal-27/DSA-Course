package datastructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(7);

        queue.enqueue(72);
        queue.enqueue(2);
        queue.enqueue(22);

        queue.getFirst();
        queue.getLast();
        queue.getLength();
        queue.printQueue();

        queue.dequeue();
        queue.getFirst();
        queue.getLast();
        queue.getLength();
        queue.printQueue();
    }
}
