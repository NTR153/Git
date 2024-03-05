package dataStructures.doublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node (int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
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

    public void append(int value) {
        Node newNode = new Node(value);
        if (length==0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length==0) return null;
        Node tempNode = tail;
        if (length==1) {
            head=null;
            tail=null;
        } else {
            tail = tail.prev;
            tail.next = null;
            tempNode.prev = null;
        }
        length--;
        return tempNode;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length==0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    
    public Node removeFirst() {
        if (length==0) return null;
        Node tempNode = head;
        if (length==1) {
            head=null;
            tail=null;
        } else {
            head = tempNode.next;
            head.prev = null;
            tempNode.next = null;
        }
        length--;
        return tempNode;
    }

    public Node get(int index) {
        if (length==0 || index<0 || index>=length) return null;
        Node tempNode = head;
        if (index<length/2) {
            for (int i=0; i<index; i++)
            tempNode=tempNode.next;
        } else {
            tempNode = tail;
            for (int i=length-1; i>index; i--) {
                tempNode=tempNode.prev;
            }
        }
        return tempNode;
    }
}
