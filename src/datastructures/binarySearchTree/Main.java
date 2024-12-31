package datastructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println(bst.insert(27));
        System.out.println(bst.insert(28));
        System.out.println(bst.insert(17));
        System.out.println(bst.insert(28));

        System.out.println(bst.root.value);
    }
}
