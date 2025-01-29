package datastructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        /**
         *              47
         *             /  \
         *           21   76
         *          / \   / \
         *        18  27 52 82
         */
        bst.rInsert(47);
        bst.rInsert(21);
        bst.rInsert(76);
        bst.rInsert(18);
        bst.rInsert(27);
        bst.rInsert(52);
        bst.rInsert(82);

        System.out.println(bst.rContains(76));
//        System.out.println(bst.rContains(17));

        System.out.println(bst.root.right.value);
        System.out.println(bst.minimumValue(bst.root));
        System.out.println(bst.minimumValue(bst.root.right));
    }
}
