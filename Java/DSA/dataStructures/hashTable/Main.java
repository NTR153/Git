package dataStructures.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashTable tempHashTable = new HashTable();
        tempHashTable.set("nails", 100);
        tempHashTable.set("tile", 50);
        tempHashTable.set("lumber", 80);
        tempHashTable.set("bolts", 240);
        tempHashTable.set("screws", 140);
        tempHashTable.set("screws", 120);
        tempHashTable.printTable();
        System.out.println(tempHashTable.get("screws"));
        System.out.println(tempHashTable.keys());
        int[] array1 = {0,1,2};
        int[] array2 = {3,4,5};
        System.out.println(itemInCommon(array1, array2));

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates); 
        
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

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> returnList = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i]==nums[j] && !returnList.contains(nums[i])) returnList.add(nums[i]);
            }
        }
        return returnList;
    }

    // public static List<Integer> findDuplicates(int[] nums) {    // Udemy solution
    //     Map<Integer, Integer> numCounts = new HashMap<>();
    //     for (int num : nums) {
    //         numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
    //     }
    //     List<Integer> duplicates = new ArrayList<>();
    //     for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
    //         if (entry.getValue() > 1) {
    //             duplicates.add(entry.getKey());
    //         }
    //     }
    //     return duplicates;
    // }

    public static Character firstNonRepeatingChar(String string) {
        int length = string.length();
        if (length==0) return null;
        HashMap<Character, Boolean> tempHashMap = new HashMap<>();
        /* finding all the methods for a class */
        // for (int i = 0; i < tempHashMap.getClass().getMethods().length; i++) {
        //     System.out.println("public method: " + tempHashMap.getClass().getMethods()[i]);
		// }
        for (int i=0; i<length; i++) {
            char x = string.charAt(i);
            if (!tempHashMap.containsKey(x)) tempHashMap.put(x,true);
            else {
                tempHashMap.put(x,false);
            }
        }
        for (int i=0; i<length; i++) {
            if (tempHashMap.get(string.charAt(i))==true) return string.charAt(i);
        }
        return null;
    }

    // public static Character firstNonRepeatingChar(String string) {       // Udemy Solution
    //     Map<Character, Integer> charCounts = new HashMap<>();
 
    //     for (int i = 0; i < string.length(); i++) {
    //         char c = string.charAt(i);
    //         charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    //     }
 
    //     for (int i = 0; i < string.length(); i++) {
    //         char c = string.charAt(i);
    //         if (charCounts.get(c) == 1) {
    //             return c;
    //         }
    //     }
 
    //     return null;
    // }
}