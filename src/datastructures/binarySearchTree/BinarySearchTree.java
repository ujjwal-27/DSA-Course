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
     * Base case-1: First the 'currentNode' is checked if it is null or not. If yes, return false.
     * Base case-2: If the 'currentNode.value == value', return true. Here, the method reaches the point, where it meets required criteria.
     * Recursive case: The 'value' from the parameter is checked with the currentNode.value:
     * - If 'value' is less than 'currentNode.value', then the method calls itself passing 'currentNode.left' as first parameter. (In BST, the left node always holds the smaller value).
     * - Likewise, if 'value' is greater than 'currentNode.value', then the method calls itself passing 'currentNode.right' as first parameter. (In BST, the right node always holds the greater value).
     * - This recursion continues until it reaches one of the base cases.
     * @param currentNode [Node] Initially, root node is sent.
     * @param value [Integer] Value to look up.
     * @return [Boolean] True/False
     */
    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);

        } else {
            return rContains(currentNode.right, value);
        }
    }

    /**
     * Here, there are two methods named 'rContains', which represents method overloading. Based on the values sent in the parameter, the methods will execute accordingly.
     * If only the 'value' is sent in the parameter, then it executes this particular method. Basically, this method is invoked than the other one.
     * Then, this method invokes another 'rContains' private method with two parameters.
     * By default, it passes 'Root node' as argument for 'currentNode'.
     * @param value [Integer] Value to look up.
     * @return [Boolean] True/False
     */
    public boolean rContains(int value) {
        return rContains(root, value);
    }

    /**
     * This method is invoked by another 'rInsert' public method with just one parameter.
     * @param currentNode [Node] Initially, root node is sent.
     * @param value [Integer] Value to insert.
     * @return [Node] Inserted node
     */
    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);

        } else {
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;
    }


    /**
     * Here, there are two methods named 'rInsert', which represents method overloading. Based on the values sent in the parameter, the methods will execute accordingly.
     * If only the 'value' is sent in the parameter, then it executes this particular method. Basically, this method is invoked than the other one.
     * Then, this method invokes another 'rInsert' private method with two parameters.
     * By default, it passes 'Root node' as argument for 'currentNode'.
     * @param value [Integer] Value to insert.
     */
    public void rInsert(int value) {
        rInsert(root, value);
    }
}
