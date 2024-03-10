package dataStructures.stackUsingArrayList;

public class Main {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static String reverseString(String myString) {
        StackUsingArrayList tempStack = new StackUsingArrayList();
        for (int i=0; i<myString.length(); i++) {
            tempStack.push(myString.charAt(i));
        }
        String returnString = "";
        for (int i=0; i<myString.length(); i++) {
            returnString+=tempStack.pop();
        }
        return returnString;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static boolean isBalancedParentheses(String testStr) {
        StackUsingArrayList tempStack = new StackUsingArrayList();
        for (int i=0; i<testStr.length(); i++) {
            if (testStr.charAt(i) == '(') {
                tempStack.push("(");
            } else if (testStr.charAt(i) == ')' && !tempStack.isEmpty()) tempStack.pop();
            else return false;
        }
        if (tempStack.size()==0) return true;
        else return false;
    }

    //Udemy Solution -
    /*
    public static boolean isBalancedParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
     */

    public static void sortStack (StackUsingArrayList<Integer> inputStack) {
        StackUsingArrayList<Integer> tempStack = new StackUsingArrayList<>();
        while (!inputStack.isEmpty()) {
            int currentElement = inputStack.pop();
            while (!tempStack.isEmpty() && tempStack.peek()>currentElement) {
                inputStack.push(tempStack.pop());
            }
            tempStack.push(currentElement);
        }
        while (!tempStack.isEmpty()) {
            inputStack.push(tempStack.pop());
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {

        StackUsingArrayList myStack = new StackUsingArrayList();
        
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        
        System.out.println("Stack after push : ");
        myStack.printStack();
        
        /*
            EXPECTED OUTPUT:
			3
			2
			1

        */

        System.out.println();

        myStack.pop();
        System.out.println("Stack after pop : ");
        myStack.printStack();

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println("Reversed String : " + reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

        System.out.println();

        testAndPrint("()", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);

        //Queue using two stacks Enqueue

        System.out.println();

        // Create a new queue
        MyQueue q = new MyQueue();

        // Enqueue some values
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // Output the front of the queue
        System.out.println("Front of the queue: " + q.peek());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + q.isEmpty());


        /*
            EXPECTED OUTPUT:
            ----------------
            Front of the queue: 1
            Is the queue empty? false

        */

        //Queue using two stacks Dequeue

        System.out.println();

        q = new MyQueue();

        // Enqueue some values
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // Output the front of the queue
        System.out.println("Front of the queue: " + q.peek());

        // Dequeue some values
        System.out.println("Dequeued value: " + q.dequeue());
        System.out.println("Dequeued value: " + q.dequeue());

        // Enqueue another value
        q.enqueue(4);

        // Output the front of the queue again
        System.out.println("Front of the queue: " + q.peek());

        // Dequeue all remaining values
        System.out.println("Dequeued value: " + q.dequeue());
        System.out.println("Dequeued value: " + q.dequeue());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + q.isEmpty());

        // Dequeue from an empty queue and check if it returns null
        System.out.println("Dequeued value from empty queue: " + q.dequeue());
    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);
        
        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);
        
        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }
        
        // Print a separator for better readability
        System.out.println("--------------");
    }
}