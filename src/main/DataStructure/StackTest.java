package DataStructure;

public class StackTest {
    public static void main(String[] args) {
        //Федя, Дичь!

        Stack stack = new Stack();
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.push(10));
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.push(20);
        stack.top();
        stack.top();
        stack.push(20);
        System.out.println(stack);
    }
}
