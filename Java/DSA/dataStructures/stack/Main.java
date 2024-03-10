package dataStructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack tempStack = new Stack(2);
        System.out.println(tempStack.getHeight());
        System.out.println(tempStack.getTop().value);
        tempStack.printStack();
    }
}
