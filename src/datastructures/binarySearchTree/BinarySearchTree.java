package datastructures.binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public ArrayList<Integer> BFS() {
        Node currentNode = root;

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            result.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return result;
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
     * In Binary Search Tree, since the smaller values are always placed on the left node, a while-loop is executed until 'currentNode.left != null'
     * On every iteration, 'currentNode.left' is assigned to the 'currentNode'.
     * @param currentNode [Node] Initially, this node can either be 'root node' or 'right node from the root'.
     * @return [int] Minimum value in the tree.
     */
    public int minimumValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
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
     * Initially, this method will always receive a currentNode as an argument.
     * Then, then 'value' is compared with 'currentNode.value':
     * - If it is less, then 'currentNode' will point to 'left' node, and this method will 'call itself' by passing 'currentNode.left' and 'value' as argument. (This is when recursion takes place)
     * -- If the 'currentNode.left' is not null, then this method will 'call itself' again accordingly.
     * -- But, if the 'currentNode.left' is null, a new node will be created using 'value', and gets returned.
     * - If it is greater, then 'currentNode' will point to 'right' node, and this method will 'call itself' by passing 'currentNode.right' and 'value' as argument.
     * -- If the 'currentNode.right' is not null, then this method will 'call itself' again accordingly.
     * -- But, if the 'currentNode.right' is null, a new node will be created using 'value', and gets returned.
     * Here, everytime the method is called, a new instance gets added to call stack, until the method reaches base case.
     * Upon reaching 'base case', 'return statement' starts to execute.
     * On every return, 'current instance' get popped out from the 'call stack'.
     * The 'value' returned from that instance goes back to 'preceding instance' from which the 'popped instance' was formed.
     * The returned value 'syncs or connects' with the 'preceding instance' accordingly, until the 'final instance' pops out of the 'stack'.
     *
     * @param currentNode [Node] Initially, root node is sent.
     * @param value [Integer] Value to insert.
     * @return [Node] Inserted node
     */
    private Node rInsert(Node currentNode, int value) {
        // Base case
        // The 'newly created' node will only be returned here, which will pop the top-most 'null' instance from the 'call stack'.
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);

        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }

        // All existing node instance with value will be returned here.
        return currentNode;
    }


    /**
     * Here, there are two methods named 'rInsert', which represents method overloading. Based on the values sent in the parameter, the methods will execute accordingly.
     * If only the 'value' is sent in the parameter, then it executes this particular method. Basically, this method is invoked than the other one in the main class.
     * [Edge case]: First it checks if node 'root' is null. If yes, a 'new node' is created and assigned to 'root'.
     * - In this scenario, if the argument value is '47', then 'root' node of value '47', and value 47 is passed through the parameter of 'rInsert' private method.
     * - In that method, the 'currentNode' will just be returned without any logic carried out.
     * - This procedure takes place only if there is no node in the tree i.e. root = null.
     * [Without edge case] If the tree has at least one node, this method will directly invoke another 'rInsert' private method, passing the 'root' node and 'value'.
     * By default, it always passes 'Root node' as argument for 'currentNode' in another private method.
     * @param value [Integer] Value to insert.
     */
    public void rInsert(int value) {
        if (root == null) { // If there is no node in the tree
            root = new Node(value);
        }

        rInsert(root, value);
    }

    /**
     * This method is invoked by another 'rDelete' public method.
     * Base case:
     * - If there is no targeted node value in the tree, then at some point 'currentNode' will be equal to 'null' as it will reach below 'leaf node'. In this case, return null.
     * Recursive case:
     * - If the 'value' is less than 'currentNode.value', then the pointer of 'currentNode' will shift towards 'left node'. This is where 'recursion' takes place as the method will 'call itself', passing 'left node' in the 'first parameter'.
     * - Likewise, if the 'value' is greater than 'currentNode.value', then the pointer of 'currentNode' will shift towards 'right node'. The method will 'call itself', passing the 'right node' in the 'first parameter'.
     * Targeted node value found:
     * - Here, there are four different cases that need to be considered:
     * -- If both the left and right pointer of 'currentNode' is null, then just return null.
     * -- If only the right pointer of 'currentNode' is null, just replace 'currentNode' with 'left node'.
     * -- If only the left pointer of 'currentNode' is null, just replace 'currentNode' with 'right node'.
     * -- If there are 'nodes' in both left and right pointer of 'currentNode':
     * --- Get the 'minimum value' from the 'right subtree' of 'currentNode', and 'replace' the value of 'currentNode' with that 'minimum value'.
     * --- Next, the node with the minimum value needs to be deleted.
     * --- For this, on the 'right subtree' of 'currentNode', 'recursion' takes place one more time as the method will 'call itself' passing 'currentNode.right' and 'minimum value' in the parameters respectively.
     * --- Rest will be handled by the rDelete method.
     * @param currentNode [Node] Initially, root node is sent.
     * @param value [int] Value of node to delete.
     * @return [Node] Delete node.
     */
    private Node rDelete(Node currentNode, int value) {
        // If the targeted 'value' is not in the tree, it will lead to null at some point.
        if (currentNode == null) return null; // Base case

        if (value < currentNode.value) { // Recursive case
            currentNode.left = rDelete(currentNode.left, value);

        } else if (value > currentNode.value) { // Recursive case
            currentNode.right = rDelete(currentNode.right, value);

        } else { // Targeted node value found. Codes above this 'else-statement' just traverses through the tree until it is determined that 'targeted value' is present or not.
            if (currentNode.left == null && currentNode.right == null) { // If both the left and right pointer of currentNode is null.
                return null;

            } else if (currentNode.right == null) { // If only the right pointer of currentNode is null.
                currentNode = currentNode.left; // Current node will be replaced with left node.

            } else if (currentNode.left == null) { // If only the left pointer of currentNode is null.
                currentNode = currentNode.right; // Current node will be replaced with right node.

            } else {
                int minimumValue = minimumValue(currentNode.right);
                currentNode.value = minimumValue;
                currentNode.right = rDelete(currentNode.right, minimumValue);
            }
        }

        return currentNode; // The node instance unwinds from the stack, everytime this 'return statement' is executed.
    }

    /**
     *
     * @param value [int] Value of node to delete.
     */
    public void rDelete(int value) {
        rDelete(root, value);
    }
}
