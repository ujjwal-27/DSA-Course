package codingExercises.binarySearchTree.constructor;

public class BinarySearchTree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

}
