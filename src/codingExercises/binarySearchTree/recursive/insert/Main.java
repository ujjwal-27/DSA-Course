package codingExercises.binarySearchTree.recursive.insert;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.rInsert(47);
        myBST.rInsert(21);
        myBST.rInsert(18);
        myBST.rInsert(76);

        /*
            THE LINES ABOVE CREATE THIS TREE:
                         47
                        /  \
                      21    76
                     /
                   18
        */



        System.out.println("Root: " + myBST.getRoot().value);
        System.out.println("\nRoot->Left: " + myBST.getRoot().left.value);
        System.out.println("\nRoot->Right: " + myBST.getRoot().right.value);
        System.out.println("\nRoot->Left->Left: " + myBST.getRoot().left.left.value);


        /*
            EXPECTED OUTPUT:
            ----------------
            Root: 47

            Root->Left: 21

            Root->Right: 76

            Root->Left: 18
        */

    }

}
