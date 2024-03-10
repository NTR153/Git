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
    }

}