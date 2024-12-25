package codingExercises.queue.enqueue;

public class Main {

    public static void main(String[] args) {

        Queue myQueue = new Queue(2);

        System.out.println("Before enqueue():");
        System.out.println("--------------");
        myQueue.printAll();

        myQueue.enqueue(1);

        System.out.println("\n\nAfter enqueue():");
        System.out.println("-------------");
        myQueue.printAll();

        /*
            EXPECTED OUTPUT:

            Before enqueue():
            --------------
            First: 2
            Last: 2
            Length: 1

            Queue:
            2


            After enqueue():
            -------------
            First: 2
            Last: 1
            Length: 2

            Queue:
            2
            1

        */

    }

}
