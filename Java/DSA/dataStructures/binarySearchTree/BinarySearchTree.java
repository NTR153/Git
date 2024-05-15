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

    // BST can not have two nodes with same value

    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node (int value) {
            this.value = value;
        }
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null) return;

        System.out.print(prefix);
        System.out.print(isLeft ? "├── " : "└── ");
        System.out.println(node.value);

        String childPrefix = prefix + (isLeft ? "│   " : "    ");
        printTree(node.left, childPrefix, true);
        printTree(node.right, childPrefix, false);
    }

    public Node getRoot() {
        return root;
    }

    public int minValue(Node node) {
        if (node==null) throw new NullPointerException();
        while (node.left!=null) {
            node=node.left;
        }
        return node.value;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root==null) {
            root=newNode;
            return true;
        }
        Node tempNode = root;

        while (true) {
            if (value<tempNode.value) {
                if (tempNode.left!=null) tempNode=tempNode.left;
                else {
                    tempNode.left = newNode;
                    return true;
                } 
            } else if (value>tempNode.value) {
                if (tempNode.right!=null) tempNode=tempNode.right;
                else  {
                    tempNode.right = newNode;
                    return true;
                } 
            } else if (value==tempNode.value) {
                return false;
            }
        }
    }

    public boolean contains(int value) {
        Node tempNode = root;
        while (tempNode!=null) {
            if (value<tempNode.value) tempNode=tempNode.left; 
            else if (value>tempNode.value) tempNode=tempNode.right;
            else if (value==tempNode.value) return true;
        }
        return false;
    }

    /* Recursion */

    private boolean rContains(Node currentNode, int value) {
        if (currentNode==null) return false;
        if (currentNode.value==value) return true;
        if (currentNode.value>value) return rContains(currentNode.left, value);
        else return rContains(currentNode.right, value);
    }

    public boolean rContains(int value) {
        Node currentNode = root;
        return rContains(currentNode, value);
    }

    private boolean rInsert(Node currentNode, int value) {
        if (value==currentNode.value) return false;
        if (value<currentNode.value) {
            if (currentNode.left==null) {
                currentNode.left = new Node(value);
                return true;
            }
            return rInsert(currentNode.left, value);
        }
        else {
            if (currentNode.right==null) {
                currentNode.right = new Node(value);
                return true;
            }
            return rInsert(currentNode.right, value);
        }
    }

    public boolean rInsert(int value) {
        if (root==null) {
            root=new Node(value);
            return true;
        }
        Node currentNode = root;
        return rInsert(currentNode, value);
    }

    /*  Udemy Solution
    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);
 
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }
    */

    // private Node deleteNode(Node currentNode, int value) {

    // }

    public void deleteNode(int value) {

    }
}