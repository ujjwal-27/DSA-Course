package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(27);
        linkedList.append(7);
        linkedList.append(2);


        linkedList.insert(0, 8);
        linkedList.insert(3, 57);
        linkedList.insert(5, 9);
        linkedList.insert(7, 11);

        linkedList.printList();
    }
}
