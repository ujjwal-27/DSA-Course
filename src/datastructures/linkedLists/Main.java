package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(27);
        linkedList.append(7);
        linkedList.append(2);

        System.out.println(linkedList.set(4, 8));
        System.out.println(linkedList.set(2, 9));
        System.out.println(linkedList.set(0, 22));

        linkedList.printList();
    }
}
