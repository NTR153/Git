package dataStructures.heap;

public class Main {
    public static void main(String[] args) {
        Heap myHeap = new Heap();
        myHeap.insert(95);
        myHeap.insert(75);
        myHeap.insert(80);
        myHeap.insert(55);
        myHeap.insert(60);
        myHeap.insert(50);
        myHeap.insert(65);
        System.out.println(myHeap.getHeap());
        myHeap.remove();
        System.out.println(myHeap.getHeap());
        myHeap.remove();
        System.out.println(myHeap.getHeap());
    }
}