package dataStructures.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));
        
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

    public static List<List<String>> groupAnagrams(String[] strings) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String,ArrayList<Integer>> tempHashMap = new HashMap<>();
        for (int i=0; i<strings.length; i++) {
            char[] tempArray = strings[i].toCharArray();
            Arrays.sort(tempArray);
            String tempString = new String(tempArray);
            if (tempHashMap.containsKey(tempString)) tempHashMap.get(tempString).add(i);        // add indexes of anagrams for canonical strings
            else {
                ArrayList<Integer> tempIntList = new ArrayList<>();
                tempIntList.add(i);
                tempHashMap.put(tempString,tempIntList);
            }
        }
        for (Map.Entry<String,ArrayList<Integer>> entry : tempHashMap.entrySet()) {
            ArrayList<String> tempArray = new ArrayList<>();
            for (int i : entry.getValue()) {
                tempArray.add(strings[i]);                                                      // get strings by indices
            }
            groupedAnagrams.add(tempArray);
        }
        return groupedAnagrams;
    }

    // public static List<List<String>> groupAnagrams(String[] strings) {          // Udemy Solution
    //     Map<String, List<String>> anagramGroups = new HashMap<>();
 
    //     for (String string : strings) {
    //         char[] chars = string.toCharArray();
    //         Arrays.sort(chars);
    //         String canonical = new String(chars);
 
    //         if (anagramGroups.containsKey(canonical)) {
    //             anagramGroups.get(canonical).add(string);
    //         } else {
    //             List<String> group = new ArrayList<>();
    //             group.add(string);
    //             anagramGroups.put(canonical, group);
    //         }
    //     }
 
    //     return new ArrayList<>(anagramGroups.values());
    // }

    // Given an array of integers nums and a target integer target, 
    // find the indices of two numbers in the array that add up to the target.
    public static int[] twoSum(int[] arr, int sum) {
        int[] returnArr = new int[0];
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i]+arr[j]==sum) {
                    returnArr = new int[2];
                    returnArr[0] = i;
                    returnArr[1] = j;
                    return returnArr;
                }
            }
        }
        return returnArr;
    }

    // public static int[] twoSum(int[] nums, int target) {             // Udemy Solution
    //     Map<Integer, Integer> numMap = new HashMap<>();
 
    //     for (int i = 0; i < nums.length; i++) {
    //         int num = nums[i];
    //         int complement = target - num;
 
    //         if (numMap.containsKey(complement)) {
    //             return new int[]{numMap.get(complement), i};
    //         }
    //         numMap.put(num, i);
    //     }
 
    //     return new int[]{};
    // }

    // Given an array of integers nums and a target integer target, 
    // write a method called subarraySum that finds the indices of a contiguous subarray in nums 
    // that add up to the target sum using a hash table (HashMap).

    public static int[] subarraySum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            int tempSum = nums[i];
            if (tempSum==target) {
                return new int[] {i,i};
            }
            for (int j=i+1; j<nums.length; j++) {
                tempSum+=nums[j];
                if (tempSum==target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{};
    }

    // public static int[] subarraySum(int[] nums, int target) {        // Udemy solution
    //     Map<Integer, Integer> sumIndex = new HashMap<>();
    //     sumIndex.put(0, -1);
    //     int currentSum = 0;
 
    //     for (int i = 0; i < nums.length; i++) {
    //         currentSum += nums[i];
    //         if (sumIndex.containsKey(currentSum - target)) {
    //             return new int[]{sumIndex.get(currentSum - target) + 1, i};
    //         }
    //         sumIndex.put(currentSum, i);
    //     }
 
    //     return new int[]{};
    // }

    // You are given a list of integers, myList, where some of the elements may be repeated. 
    // Your task is to write a Java method that removes all duplicate elements from the list 
    // and returns a new list containing only the unique elements

    public static List<Integer> removeDuplicates(List<Integer> myList) {         // Udemy Solution
        Set<Integer> uniqueSet = new HashSet<>(myList);
        return new ArrayList<>(uniqueSet);
    }
}