package dataStructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tempBST = new BinarySearchTree();
        tempBST.insert(2);
        tempBST.insert(1);
        tempBST.insert(3);
        System.out.println(tempBST.contains(2));
        System.out.println(tempBST.rContains(5));
    }
}