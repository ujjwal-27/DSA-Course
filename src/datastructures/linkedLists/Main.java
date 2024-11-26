package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.prepend(27);
        linkedList.prepend(7);
        linkedList.prepend(2);

        linkedList.printList();

//        System.out.println(linkedList.removeLast().value);
//        System.out.println(linkedList.removeLast().value);
//        System.out.println(linkedList.removeLast());

        linkedList.getHead();
        linkedList.getTail();
        linkedList.getLength();
    }
}
