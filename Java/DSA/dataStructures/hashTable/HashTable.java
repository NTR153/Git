package dataStructures.hashTable;

import java.util.ArrayList;

/**
 * HastTable
 */
public class HashTable {
    // Hash Table is used to add key value pair to an address.
    // It is both "one way" (can get address using key but cannot get key using address) and "deterministic" (always get same address)

    // Collision - A collision occurs when more than one value to be hashed by a particular hash function 
    // hash to the same slot in the table or data structure (hash table) being generated by the hash function.

    // Collision can be handled by -
    // 1. Adding the key value pair to same address, also known as "Separate Chaining". eg. Linked List
    // 2. Adding the key value pair to the next open address (non consumed one), also known as "Linear Probing" or "Open Addressing" 

    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node (String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable () {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i=0; i<size; i++) {
            System.out.println(i + " : ");
            Node tempNode = dataMap[i];
            while (tempNode != null) {
                System.out.println(" { " + tempNode.key + " = " + tempNode.value + " } ");
                tempNode = tempNode.next;
            }
        }
    }

    private int hash(String key) {          // O(1)
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i=0; i<keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash+asciiValue*23) % dataMap.length;
        }
        return hash;
    }

    // O(1) as hash method is O(1) and a very
    // good, randomized hash table is considered
    // Also, the iterations whithin while loop 
    // are unknown
    public void set(String key, int value) {            //adds another pair even if the key exists
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index]==null) {
            dataMap[index]=newNode;
        }
        else {
            Node tempNode = dataMap[index];
            while (tempNode.next!=null) {
                tempNode=tempNode.next;
            }
            tempNode.next=newNode;
        }
    }

    // public void set(String key, int value) {        //update the value if key exists
	//     Node newNode = new Node(key,value);
	//     int index = hash(key);
	//     if (dataMap[index]==null) {
	//         dataMap[index] = newNode;
	//     } else {
    //         Node tempNode = dataMap[index];
	//         while (tempNode.next!=null) {
	//             if (tempNode.key.equals(key)) {
	//                 tempNode.value = value;
	//                 return;
	//             }
	//             tempNode = tempNode.next;
	//         }
	//         tempNode.next = newNode;
	//     }
	// }

    // public void set(String key, int value) {            //add value to existing value corresponding to the key
    //     int index = hash(key);
    //     Node newNode = new Node(key, value);
    //     if (dataMap[index] == null) {
    //         dataMap[index] = newNode;
    //     } else {
    //         Node temp = dataMap[index];
    //         if (temp.key == key) {
    //             temp.value += value;
    //             return;
    //         }
    //         while (temp.next != null) {
    //             temp = temp.next;
    //             if (temp.key == key) {
    //                 temp.value += value;
    //                 return;
    //             }
    //         }
    //         temp.next = newNode;
    //     }
    // }

    // O(1) as hash method is O(1) and a very
    // good, randomized hash table is considered
    // Also, the iterations whithin while loop 
    // are unknown
    public int get(String key) {
        int index = hash(key);
        Node tempNode = dataMap[index];
        while (tempNode!=null) {
            if (tempNode.key.equals(key)) return tempNode.value;
            tempNode=tempNode.next;
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i=0; i<size; i++) {
            Node tempNode = dataMap[i];
            while (tempNode!=null) {
                allKeys.add(tempNode.key);
                tempNode = tempNode.next;
            }
        }
        return allKeys;
    }
}