package dataStructures.stack;

public class Stack {

    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public Node getTop() {
        return this.top;
    } 

    public int getHeight() {
        return this.height;
    }

    public void printStack() {
        Node tempNode = top;
        while (tempNode!=null) {
            System.out.println(tempNode.value);
            tempNode=tempNode.next;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height==0) top=newNode;
        else {
            newNode.next=top;
            top=newNode;
        }
        height++;
    }

    public Node pop() {
        if (height==0) return null;
        Node tempNode=top;
        top=tempNode.next;
        tempNode.next=null;
        height--;
        return tempNode;
    }
}
