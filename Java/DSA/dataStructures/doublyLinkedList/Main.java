package dataStructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList tempList = new DoublyLinkedList(1);
        tempList.append(2);
        // tempList.removeFirst();
        tempList.prepend(5);
        tempList.printList();
        // System.out.println(tempList.get(2).value);
    }
}
