package dataStructures.hashTable;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashTable tempHashTable = new HashTable();
        tempHashTable.set("nails", 100);
        tempHashTable.set("tile", 50);
        tempHashTable.set("lumber", 80);
        tempHashTable.set("bolts", 240);
        tempHashTable.set("screws", 140);
        tempHashTable.printTable();
        System.out.println(tempHashTable.get("tile"));
        System.out.println(tempHashTable.keys());
        int[] array1 = {0,1,2};
        int[] array2 = {3,4,5};
        System.out.println(itemInCommon(array1, array2));
        
    }

    // Interview Question - return true if any itemInCommon in O(n) time
    // Logic - considering searching in HashMap as O(1), we traverse over both arrays once.
    // Instead of having nested loops for comparing elements.
    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> tempHashMap = new HashMap<>();
        for (int i : array1) {
            tempHashMap.put(i, true);
        }
        for (int i : array2) {
            if (tempHashMap.containsKey(i)) return true;
        }
        return false;
    }
}