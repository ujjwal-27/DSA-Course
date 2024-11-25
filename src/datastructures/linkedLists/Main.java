package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);

        linkedList.append(7);

        System.out.println(linkedList.removeLast().value);
        System.out.println(linkedList.removeLast().value);
        System.out.println(linkedList.removeLast());

//        linkedList.printList();

//        linkedList.getHead();
//        linkedList.getTail();
//        linkedList.getLength();
    }
}
