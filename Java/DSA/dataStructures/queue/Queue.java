package dataStructures.queue;

public class Queue {

    //For Queue, we add the items to the last and remove items from the first
    //to have O(1) time complexity for both operations
    //This is also known as FIFO (First In First Out)

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

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length==0) {
            first=newNode;
            last=newNode;
        } else {
            last.next=newNode;
        }
        length++;
    }

    public Node dequeue() {
        if (length==0) return null;
        Node tempNode = first;
        if (length==1) {
            first=null;
            last=null;
        } else {
            first=tempNode.next;
            tempNode.next=null;
        }
        length--;
        return tempNode;
    }
}
