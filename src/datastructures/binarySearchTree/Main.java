package datastructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(27);
        bst.insert(55);
        bst.insert(17);
        bst.insert(83);
        bst.insert(28);
        bst.insert(25);
        bst.insert(12);

        System.out.println(bst.contains(17));
    }
}
