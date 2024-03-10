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

    public boolean set(int index, int value) {
        if (index<0 || index>=length) return false;
        Node tempNode = get(index);
        tempNode.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index<0 || index>length) return false;
        Node newNode = new Node(value);
        Node tempNode = head;
        if (index==0) {
            prepend(value);
            return true;
        } else if (index==length) {
            append(value);
            return true;
        } 
        tempNode=get(index);
        newNode.prev=tempNode.prev;
        newNode.next=tempNode;
        tempNode.prev=newNode;
        newNode.prev.next=newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index<0 || index>=length) return null;
        Node tempNode = get(index);
        if (index==0) {
            return removeFirst();
        } else if(index==length-1) {
            return removeLast();
        } 
        tempNode.prev.next = tempNode.next;
        tempNode.next.prev = tempNode.prev;
        tempNode.prev=null;
        tempNode.next=null;
        length--;
        return tempNode;
    }

    //Swap First and Last Node's values
    public void swapFirstLast() {
	    if (length<2) return;
	    tail.value = tail.value+head.value;
	    head.value = tail.value-head.value;
	    tail.value = tail.value-head.value;
	}

    public void reverse() {
	    if (length<2) return;
	    Node prevNode = null;
	    Node tempNode = head;
	    Node nextNode = null;
	    for (int i=0; i<length; i++) {
	        nextNode = tempNode.next;
	        if (i==0) {
	            tail=tempNode;
	        }
	        if (i==length-1) {
	            head=tempNode;
	        }
            tempNode.prev = nextNode;
            tempNode.next = prevNode;
            prevNode = tempNode;
            tempNode = nextNode;
	    }
	}

    public boolean isPalindrome() {
	    
	    if (length<=1) return true;
	    
	    int[] valuesArray = new int[length];
	    
	    Node tempNode = head;
	    for (int i=0; i<length; i++) {
	        valuesArray[i] = tempNode.value;
	        tempNode=tempNode.next;
	    }
	    
	    tempNode = tail;
	    for (int i=length-1; i>=0; i--) {
	        if (valuesArray[length-1-i] != tempNode.value) return false;
	        tempNode=tempNode.prev;
	    }
	    return true;
	}

    //Udemy Solution
    /*
    public boolean isPalindrome() {
        if (length <= 1) return true;
        
        Node forwardNode = head;
        Node backwardNode = tail;
        for (int i = 0; i < length / 2; i++) {
            if (forwardNode.value != backwardNode.value) return false;
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        return true;
    }
     */

    // function that swaps the values of adjacent nodes in the linked list
    public void swapPairs() {
        if (length<=1) return;
        Node tempNode = head;
        Node prevNode = null;
        Node nextNode = null;
        int i = 0;
        while(tempNode!=null) {
            nextNode=tempNode.next;
            if (i%2==1) {
                tempNode.next=prevNode;
                tempNode.prev=nextNode;
            }
            i++;
            prevNode=tempNode;
            tempNode=nextNode;
        }
    }
}
