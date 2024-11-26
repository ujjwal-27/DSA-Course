package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(27);
        linkedList.append(7);

        System.out.println(linkedList.get(0).value);
        System.out.println(linkedList.get(1).value);
        System.out.println(linkedList.get(2).value);
        System.out.println(linkedList.get(3));
    }
}
