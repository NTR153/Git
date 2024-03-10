package dataStructures.queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node (int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first=newNode;
        last=newNode;
        length=1;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printQueue() {
        Node tempNode = first;
        while (tempNode!=null) {
            System.out.println(tempNode.value);
            tempNode=tempNode.next;
        }
    }
}
