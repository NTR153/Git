package dataStructures.linkedList;

import java.util.HashSet;

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

    public int getLengthIfNotPresentByDefault() {
        int returnLength = (head == null) ? 0 : 1;
	    Node tempNode = head;
	    while (tempNode != tail) {
	        returnLength++;
	        tempNode = tempNode.next;
	    }
        return returnLength;
    }

    public void printList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
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
        if (index>=length || index<0) {
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

    // public boolean set(int index, int value) {
    //     if (index < 0 || index >= length) {
    //         return false;
    //     }
    //     int i = 0;
    //     Node tempNode = head;
    //     while (i != index) {
    //         tempNode = tempNode.next;
    //         i++;
    //     }
    //     tempNode.value = value;
    //     return true;
    // }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        Node newNode = new Node(value);
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node tempNode = get(index-1);
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == length-1) {
            return removeLast();
        }
        Node tempNode1 = get(index - 1);
        Node tempNode2 = tempNode1.next;
        tempNode1.next = tempNode2.next;
        tempNode2.next = null;
        length--;
        return tempNode2;
    }

    public void reverse() {
        if (length > 1) {
            Node tempNode = head;
            head = tail;
            tail = tempNode;
            Node afterNode = tempNode.next;
            Node beforeNode = null;
            while (tempNode != head) {
                tempNode.next = beforeNode;
                beforeNode = tempNode;
                tempNode = afterNode;
                afterNode = tempNode.next;
            }
            tempNode.next = beforeNode;
        }
    }

    public Node findMiddleNode() {
        Node tempNode = head;
	    if (length == 0) return null;
	    tempNode = head;
	    int middleIndex = length/2;
	    int i=0;
	    while (i!=middleIndex) {
	        tempNode = tempNode.next;
	        i++;
	    }
	    return tempNode;
	}

    public boolean hasLoop() {
        // Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.
	    Node slow = head;
	    Node fast = head;
	    while (slow!=tail && fast!=null) {
	        slow = slow.next;
	        fast = (fast.next!=null) ? fast.next.next : null;
	        if (slow == fast) {
	            return true;
	        }
	    }
	    return false;
	}

    public Node findKthFromEnd(int k) {
	    int length = (head == null) ? 0 : 1;
	    Node tempNode = head;
	    while (tempNode != tail) {
	        length++;
	        tempNode = tempNode.next;
	    }
	    if (length == 0 || k>length) return null;
	    tempNode = head;
	    int index = length - k;
	    int i = 0;
	    while (i != index) {
	        tempNode = tempNode.next;
	        i++;
	    }
	    return tempNode;
	}

    public void partitionList(int x) {
        // Given a value x you need to rearrange the linked list such that all nodes with a value less than x come before all nodes with a value greater than or equal to x
        if (head == null) return;
        Node prevSeparatingNode = null;
        Node separatingNode = head;
        Node prevSearchNode = null;
        Node searchNode = head;
        Node tempNode = null;
        while (searchNode != null) {
            if (searchNode.value < x && separatingNode.value >= x) {
                tempNode = searchNode;
                searchNode = searchNode.next;
                prevSearchNode.next = searchNode;
                tempNode.next = separatingNode;
                if (prevSeparatingNode != null) {
                    prevSeparatingNode.next = tempNode;
                    prevSeparatingNode = tempNode;
                } else {
                    head = tempNode;
                    prevSeparatingNode = head;
                }
                // tempNode = null;
            } else {
                prevSearchNode = searchNode;
                searchNode = searchNode.next;
            }
            if (separatingNode.value < x) {
                prevSeparatingNode = separatingNode;
                separatingNode = separatingNode.next;
            }
        }
    }

    public void removeDuplicates() {
        HashSet<Integer> values = new HashSet<>();
        if (head == null) return;
        Node traverseNode = head;
        Node preNode = null;
        Node tempNode = null;
        while (traverseNode!=null) {
            if (values.contains(traverseNode.value)) {
                values.add(traverseNode.value);
                tempNode = traverseNode;
                traverseNode = traverseNode.next;
                preNode.next = traverseNode;
                tempNode.next = null;
            } else {
                values.add(traverseNode.value);
                preNode = traverseNode;
                traverseNode = traverseNode.next;
            }
        }
    }

    public int binaryToDecimal() {
        int num = 0;
        Node tempNode = head;
        for (int i=length-1; i>=0; i--) {
            num += Math.pow(2,i)*tempNode.value;
            tempNode = tempNode.next;
        }
        return num;
    }
}
