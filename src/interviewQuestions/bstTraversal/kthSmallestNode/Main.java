package interviewQuestions.bstTraversal.kthSmallestNode;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.kthSmallest(1));  // Expected output: 2
        System.out.println(bst.kthSmallest(3));  // Expected output: 4
        System.out.println(bst.kthSmallest(6));  // Expected output: 7

    }

}

