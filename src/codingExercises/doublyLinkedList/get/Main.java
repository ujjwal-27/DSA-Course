package codingExercises.doublyLinkedList.get;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList myDLL = new DoublyLinkedList(22);
        myDLL.append(7);
        myDLL.append(27);
        myDLL.append(77);
        myDLL.append(7);


        System.out.println(myDLL.get(2).value);


        /*
            EXPECTED OUTPUT:
            ----------------
            3

        */

    }

}
