package dataStructures.stackUsingArrayList;

public class MyQueue {

    //Queue using two stacks

    private StackUsingArrayList<Integer> stack1;
    private StackUsingArrayList<Integer> stack2;

    public MyQueue() {
        stack1 = new StackUsingArrayList<>();
        stack2 = new StackUsingArrayList<>();
    }

    public void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return stack1.pop();
        }
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
    
}