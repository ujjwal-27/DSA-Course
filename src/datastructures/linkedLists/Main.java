package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(27);
        linkedList.append(7);
        linkedList.append(2);


        System.out.println("removed: " + linkedList.remove(2).value);

        linkedList.printList();
    }
}
