package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);

        linkedList.append(7);
        linkedList.append(9);
        linkedList.append(23);

        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();

        linkedList.printList();

//        linkedList.getHead();
//        linkedList.getTail();
//        linkedList.getLength();
    }
}
