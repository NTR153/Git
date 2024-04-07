package dataStructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    // Heap is a complete binary tree.
    // Meaning any node is not skipped while filling it from left to right.
    // No relation between same level nodes.
    // Heap can have duplicates.
    
    // For max heap -
    // Each node has a value greater than or equal to it's descendants.

    // For mean heap -
    // Each node has a value less than or equal to it's descendants.

    // Sometimes, in order to simplify calculations, we leave the first element empty.
    // Following implementation is without leaving an empty element in the array

    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2*index+1;
    }

    private int rightChild(int index) {
        return 2*index+2;
    }

    private int parent(int index) {
        return (index-1)/2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (current>0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
}