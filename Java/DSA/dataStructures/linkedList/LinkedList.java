package dataStructures.linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
    
        Node (int value) {
            this.value = value;
        }
    }
    
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public void append(int Value) {
        Node newNode = new Node(Value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        Node tempNode = head;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            head = null;
            length--;
            return head;
        }
        while (tempNode.next != tail) {
            tempNode = tempNode.next;
        }
        tail = tempNode;
        tempNode = tail.next;
        tail.next = null;
        length--;
        return tempNode;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node tempNode = head;
        head = tempNode.next;
        length--;
        if (length == 0) {
            tail = null;
        }
        return tempNode;
    }

    public Node get(int index) {
        if (index>length || index<0) {
            return null;
        }
        int i=0;
        Node tempNode = head;
        while (i != index) {
            tempNode = tempNode.next;
            i++;
        }
        return tempNode;
    }
}
