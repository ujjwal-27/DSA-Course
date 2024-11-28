package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(27);
        linkedList.append(7);
        linkedList.append(59);
        linkedList.append(33);
        linkedList.append(2);


        linkedList.reverse();

        linkedList.printList();
    }
}
