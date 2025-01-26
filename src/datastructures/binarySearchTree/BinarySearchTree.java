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

    public boolean contains(int value) {
        if (root == null) return false;

        Node temp = root;

        while (temp != null) {
            if (temp.value == value) {
                return true;

            } else if (value < temp.value) {
                temp = temp.left;

            } else {
                temp = temp.right;
            }
        }

        return false;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        // If there is no node in the binary tree
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;

        // Since, every if-condition inside while loop returns true/false at some point, the condition for this loop is set to true
        while (true) {
            if (newNode.value == temp.value) return false; // All the values in binary tree must be unique

            if (newNode.value < temp.value) { // If the value of new node is less than value of temp, shift to left side.
               if (temp.left == null) {
                   temp.left = newNode;
                   return true;
               }

               temp = temp.left;

            } else { // If the value of new node is greater than value of temp, shift to right side.
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }

                temp = temp.right;
            }
        }
    }

    /**
     * This method is invoked by another 'rContains' public method with just one parameter.
     * @param currentNode [Node] Root node
     * @param value [Integer] Value to look up.
     * @return [Boolean] True/False
     */
    private boolean rContains(Node currentNode, int value) {

    }

    /**
     * Here, there are two methods named 'rContains', which represents method overloading. Based on the values sent in the parameter, the methods will execute accordingly.
     * If only the 'value' is sent in the parameter, then it executes this method.
     * Then, this method invokes another 'rContains' private method with two parameters.
     * By default, it passes 'Root node' as argument for 'currentNode'.
     * @param value [Integer] Value to look up.
     * @return [Boolean] True/False
     */
    public boolean rContains(int value) {
        return rContains(root, value);
    }
}
