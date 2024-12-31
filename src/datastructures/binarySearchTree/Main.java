package datastructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println(bst.insert(27)); // true
        System.out.println(bst.insert(55)); // true
        System.out.println(bst.insert(17)); // true
        System.out.println(bst.insert(83)); // true
        System.out.println(bst.insert(28)); // true
        System.out.println(bst.insert(55)); // false
        System.out.println(bst.insert(25)); // true
        System.out.println(bst.insert(12)); // true

        System.out.println("-------------------------------");

        System.out.println(bst.root.left.left.value); // 12
        System.out.println(bst.root.left.right.value); // 25
        System.out.println(bst.root.right.left.value); // 28
        System.out.println(bst.root.right.right.value); // 83
        System.out.println(bst.root.left.value); // 17
        System.out.println(bst.root.right.value); // 55
    }
}
