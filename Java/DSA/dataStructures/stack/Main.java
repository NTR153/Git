package dataStructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack tempStack = new Stack(1);
        tempStack.push(2);
        System.out.println("Height : " + tempStack.getHeight());
        System.out.println("Top : " + tempStack.getTop().value);
        tempStack.printStack();
    }
}
