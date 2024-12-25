package codingExercises.stack.push;

public class Main {

    public static void main(String[] args) {

        Stack myStack = new Stack(2);

        System.out.println("Before push():");
        System.out.println("--------------");
        myStack.printAll();

        myStack.push(1);

        System.out.println("\n\nAfter push():");
        System.out.println("-------------");
        myStack.printAll();

        /*
            EXPECTED OUTPUT:

			Before push():
			--------------
			Top: 2
			Height: 1

			Stack:
			2


			After push():
			-------------
			Top: 1
			Height: 2

			Stack:
			1
			2

        */

    }

}
