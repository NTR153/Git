package dataStructures.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList tempList = new LinkedList(24);
        tempList.append(25);
        tempList.append(26);
        tempList.removeLast();
        tempList.printList();
        System.out.println(tempList.getLength());
    }
}
