package datastructures.binarySearchTree;

public class BinarySearchTree {
    Node root; // represents the top-most node in the tree

    class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;

        while (temp != null) {
            if (newNode.value == temp.value) return false; // all the values in binary tree must be unique

            if (newNode.value < temp.value) {
               if (temp.left == null) {
                   temp.left = newNode;
                   temp = null;

               } else {
                   temp = temp.left;
               }

            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    temp = null;

                } else {
                    temp = temp.right;
                }
            }
        }

        return true;
    }
}
