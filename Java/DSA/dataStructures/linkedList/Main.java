package dataStructures.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList tempList = new LinkedList(0);
        tempList.append(1);
        tempList.append(2);
        System.out.println(tempList.removeLast().value);
        tempList.printList();
    }
}
