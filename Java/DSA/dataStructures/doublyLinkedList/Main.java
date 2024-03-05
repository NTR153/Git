package dataStructures.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList tempList = new DoublyLinkedList(1);
        tempList.append(2);
        tempList.append(3);
        tempList.append(4);
        // tempList.removeFirst();
        tempList.prepend(5);
        tempList.set(5, 6);
        tempList.printList();
        // System.out.println(tempList.get(3).value);
    }
}
