package datastructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(7);

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
