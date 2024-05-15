package dataStructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tempBST = new BinarySearchTree();
        tempBST.insert(2);
        tempBST.insert(1);
        tempBST.rInsert(3);
        tempBST.rInsert(5);
        tempBST.rInsert(0);
        System.out.println(tempBST.rInsert(4));
        System.out.println(tempBST.contains(2));
        System.out.println(tempBST.rContains(5));
        tempBST.printTree();
        System.out.println(tempBST.minValue(tempBST.getRoot()));
        System.out.println(tempBST.minValue(tempBST.getRoot().right));
    }
}