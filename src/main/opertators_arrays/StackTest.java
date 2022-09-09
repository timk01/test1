package opertators_arrays;

import java.util.Arrays;

public class StackTest {
    public static void main(String[] args) {
        //Федя, Дичь!

        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(-10);
        stack.push(-210);
        stack.push(10);
        stack.push(20);
        stack.push(-10);
        stack.push(-210);
        stack.push(10);
        stack.push(20);
        stack.push(-10);
        stack.push(-210);
        System.out.println("initial stack: " + stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());

                /*int[] copyArray = new int[ints.length - 1];
        System.arraycopy(ints, 0, copyArray, 0, ints.length - 1 - 2);
        ints = copyArray;
        System.out.println("reducedArr " + Arrays.toString(ints));*/

//        int[] ints = new int[]{1, 2, 3, 4, 5};
/*        System.arraycopy(ints, 0, ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));*/
/*        System.out.println(Arrays.toString(ints));
        int[] copyArray = new int[ints.length - 1];
        System.arraycopy(ints, 0, copyArray, 0, ints.length - 1);
        System.out.println(Arrays.toString(copyArray));*/

    }
}
