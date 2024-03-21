package dataStructures.hashTable;

public class Main {
    public static void main(String[] args) {
        HashTable tempHashTable = new HashTable();
        tempHashTable.set("nails", 100);
        tempHashTable.set("tile", 50);
        tempHashTable.set("lumber", 80);
        tempHashTable.set("bolts", 240);
        tempHashTable.set("screws", 140);
        tempHashTable.printTable();
    }
}
