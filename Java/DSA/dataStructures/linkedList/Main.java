package dataStructures.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList tempList = new LinkedList(24);
        tempList.append(25);
        tempList.append(26);
        tempList.append(25);
        tempList.append(26);
        // System.out.println(tempList.insert(2, 65));
        tempList.printList();
        tempList.reverse();
        System.out.println("");
        tempList.printList();
        System.out.println("");
        // System.out.println(tempList.get(-1));
        // System.out.println(tempList.getLength());
        System.out.println(tempList.hasLoop());
    }
}
