package dataStructures.heap;

public class Main {
    public static void main(String[] args) {
        Heap myHeap = new Heap();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);
        System.out.println(myHeap.getHeap());
        myHeap.insert(100);
        System.out.println(myHeap.getHeap());
        myHeap.insert(75);
        System.out.println(myHeap.getHeap());
    }
}