package dataStructures.binarySearchTree;

public class BinarySearchTree {
    // Full tree -> Either zero or two nodes on every node
    // Perfect tree -> any level on the tree that has any node/s is completely filled across
    // Complete tree -> Filled tree from left to right with no gap/s

    // For a tree to be a binary search tree (BST), left to right is less to greater
    // O(log n) for finding, removing and adding a node on average for BST
    // For worst case scenario, 
    // insert() is O(1), O(n),
    // lookup() by value is O(n), O(log n),
    // remove() by value is O(n), O(log n)
    // respectively for linked list and BST

    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node (int value) {
            this.value = value;
        }
    }
}
