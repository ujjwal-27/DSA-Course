package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(27);
        linkedList.append(7);

        System.out.println("removed: " + linkedList.removeFirst().value);
        System.out.println("removed: " + linkedList.removeFirst().value);
        System.out.println("removed: " + linkedList.removeFirst().value);
        System.out.println(linkedList.removeFirst());

        linkedList.printList();

        linkedList.getHead();
        linkedList.getTail();
        linkedList.getLength();
    }
}
