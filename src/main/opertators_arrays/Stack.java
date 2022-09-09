package opertators_arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

public class Stack {

    private int size = 0;
    private int[] ints;
    private static final int CAPACITY = 10;

    public Stack() {
        ints = new int[CAPACITY];
    }

    public static void main(String[] args) {
    }

    public void push(int elem) {
        if (size == ints.length) {
            ints = Arrays.copyOf(ints, ints.length * 2);
        }
        ints[size++] = elem;
    }

    public int pop() {
        if (size > 0) {
            int elem = ints[size - 1];
            ints[size] = ints[--size];
            return elem;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(ints[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
