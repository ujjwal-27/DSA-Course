package datastructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println(bst.insert(27));
        System.out.println(bst.insert(55));
        System.out.println(bst.insert(17));
        System.out.println(bst.insert(83));
        System.out.println(bst.insert(28));
        System.out.println(bst.insert(55));
        System.out.println(bst.insert(25));
        System.out.println(bst.insert(12));

        System.out.println(bst.root.left.left.value);
        System.out.println(bst.root.left.right.value);
        System.out.println(bst.root.right.left.value);
        System.out.println(bst.root.right.right.value);
        System.out.println(bst.root.left.value);
        System.out.println(bst.root.right.value);
    }
}
