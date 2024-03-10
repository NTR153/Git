package dataStructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue tempQueue = new Queue(1);
        tempQueue.enqueue(2);
        tempQueue.dequeue();
        System.out.println("First : " + tempQueue.getFirst().value);
        System.out.println("Last : " + tempQueue.getLast().value);
        System.out.println("Queue : ");
        tempQueue.printQueue();
        System.out.println("Length : " + tempQueue.getLength());
    }
}
