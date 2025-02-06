package interviewQuestions.bstTraversal.kthSmallestNode;

import java.util.Stack;


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

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    /**
     * APPROACH 1 (self-implementation):
     * The purpose of this method is to find the 'kth smallest node' in the 'BST'.
     * For this, 'currentNode' is created and assigned with 'root' node, and an empty 'stack' is created.
     * A 'while-loop' is executed until 'stack' is not empty or 'currentNode' is not null.
     * - On each iteration, 'currentNode' is checked if it is null or not.
     * - If it is not null, 'currentNode' is pushed into 'stack', and moves to its 'left' node.
     * - If it is null, a node is removed (popped) from 'stack', and value of 'k' is decreased by 1.
     * -- If k == 0, the value of 'currentNode' is returned.
     * -- Else, 'currentNode' shifts to its 'right' node.
     * Finally, if there is no required smallest node in BST, return 'null'.
     * @param k [int] Position of smallest node to find in BST.
     * @return [Integer] 'Value' of the smallest node in BST OR 'null'.
     */
//    public Integer kthSmallest(int k) {
//        Node currentNode = root;
//        Stack<Node> stack = new Stack<>();
//
//        while (!stack.isEmpty() || currentNode != null) {
//            if (currentNode == null) {
//                currentNode = stack.pop();
//                k--;
//
//                if (k == 0) return currentNode.value;
//
//                currentNode = currentNode.right;
//
//            } else {
//                stack.push(currentNode);
//                currentNode = currentNode.left;
//            }
//        }
//
//        return null;
//    }

    /**
     * APPROACH 2 (course-based):
     * The purpose of this method is to find the 'kth smallest node' in the 'BST'.
     * For this, 'currentNode' is created and assigned with 'root' node, and an empty 'stack' is created.
     * A 'while-loop' is executed until 'stack' is not empty or 'currentNode' is not null.
     * - On each iteration, a nest while-loop is executed until currentNode is not null.
     * -- And, on each iteration, currentNode is pushed into stack, and shifted to its left node.
     * - If the condition of nested while-loop is not satisfied, a node from stack is removed (popped), and the popped node is assigned to currentNode.
     * - Then, value of 'k' is decreased by 1.
     * - If k == 0, the value of 'currentNode' is returned.
     * - Else, 'currentNode' shifts to its 'right' node.
     * Finally, if there is no required smallest node in BST, return 'null'.
     * @param k [int] Position of smallest node to find in BST.
     * @return [Integer] 'Value' of the smallest node in BST OR 'null'.
     */
    public Integer kthSmallest(int k) {
        Node currentNode = root;
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            k--;

            if (k == 0) return currentNode.value;

            currentNode = currentNode.right;
        }

        return null;
    }

}

