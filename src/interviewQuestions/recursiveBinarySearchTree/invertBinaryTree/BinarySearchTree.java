package interviewQuestions.recursiveBinarySearchTree.invertBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    private Node insert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = insert(currentNode.right, value);
        }
        return currentNode;
    }
    public void insert(int value) {
        if (root == null) root = new Node(value);
        insert(root, value);
    }

    /**
     * This method converts Binary Search Tree to ArrayList using Queue Linked List.
     * As 'queue' follows 'FIFO (First In First Out)' principle, it always removes the nodes at the front (in the beginning) of the 'queue'.
     * Initially, the 'currentNode' (root node) is added to the 'queue'.
     * Then, a while-loop is executed until the size of 'queue' is greater than 0:
     * - On each iteration, 'first node' from the 'queue' is removed and assigned to 'currentNode'.
     * - If the 'currentNode' is not null, the value of 'currentNode' will be added to 'ArrayList' (results).
     * - Then, the left and right child of the 'currentNode' will be added to 'queue'.
     * - There will be a condition when 'currentNode' will be 'null'. This happens when the iteration reaches the point when the left and right child (null) of leaf node is added to queue.
     * - The children of leaf node is always null, which why it is called leaf node.
     * - That 'null' value is just removed from the 'queue', and won't be added to ArrayList (results) since it won't satisfy the if-condition (currentNode != null).
     * Understanding the flow of this method with the help of diagram will make it more comprehensible.
     * @return [ArrayList] List of integers derived from BST.
     */
    public ArrayList<Integer> BFS() {
        Node currentNode = root; // assigning current node with the root node of tree.
        Queue<Node> queue = new LinkedList<>(); // declaring queue
        ArrayList<Integer> results = new ArrayList<>(); // This is where all the node values from BST will be stored.
        if (currentNode != null) {
            queue.add(currentNode); // Initially adding currentNode in queue.
        }

        while (queue.size() > 0) {
            currentNode = queue.remove(); // This removes first node from queue, and stores it in currentNode variable.
            if (currentNode != null) {
                results.add(currentNode.value); // The value of currentNode is then added in the list (results).
                queue.add(currentNode.left); // The left node of currentNode is added to queue
                queue.add(currentNode.right); // The right node of currentNode is added to queue
            }
        }
        return results;
    }

    public void invert() {
        root = invertTree(root);
    }

    /**
     * The best way to understand the working of this method is by 'drawing diagrams' of step by step implementations.
     * The diagram of 'call stack' will help the most, and track the 'recursion' how it's taking place.
     * The comments in the 'solution explanation' of this question is also really helpful.
     * @param node [Node]
     * @return [Node] Root node
     */
    private Node invertTree(Node node) {
        if (node == null) return null; // base case

        Node temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);

        return node;
    }

    //   +===================================================+
    //   |              WRITE YOUR CODE HERE                 |
    //   | Description:                                      |
    //   | - Inverts a binary tree by swapping the left and  |
    //   |   right children of all nodes in the tree.        |
    //   | - This method is private and intended for internal|
    //   |   use within the class.                           |
    //   | - It operates recursively, visiting each node and |
    //   |   swapping its children.                          |
    //   |                                                   |
    //   | Parameters:                                       |
    //   | - node: The current node to process.              |
    //   |                                                   |
    //   | Return:                                           |
    //   | - The node after its subtree has been inverted.   |
    //   |                                                   |
    //   | Tips:                                             |
    //   | - The base case for the recursion is when the     |
    //   |   method encounters a null node.                  |
    //   | - A temporary node is used to facilitate the swap |
    //   |   of the left and right children.                 |
    //   +===================================================+

}


