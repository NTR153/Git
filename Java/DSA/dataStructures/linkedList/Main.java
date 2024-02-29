package dataStructures.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList tempList = new LinkedList(24);
        tempList.append(25);
        tempList.append(26);
        tempList.removeLast();
        tempList.prepend(55);
        tempList.removeFirst();
        tempList.printList();
        System.out.println("");
        // System.out.println(tempList.get(-1));
        // System.out.println(tempList.getLength());
    }
}
