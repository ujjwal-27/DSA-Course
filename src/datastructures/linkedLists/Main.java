package datastructures.linkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(27);
        linkedList.append(7);
        linkedList.append(2);

        System.out.println(linkedList.getByValue(9)); // false
        System.out.println(linkedList.getByValue(27));
        System.out.println(linkedList.getByValue(8));
        System.out.println(linkedList.getByValue(4));
        System.out.println(linkedList.getByValue(2));
    }
}
