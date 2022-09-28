package DataStructure;

public class Stack {

    private int size = 0;
    private Integer[] ints;
    private static final int CAPACITY = 10;

    public Stack() {
        ints = new Integer[CAPACITY];
    }

    public boolean push(Integer elem) {
        if (elem != null) {
            resizeArray();
            ints[size++] = elem;
            return true;
        }
        return false;
    }

    public Integer pop() {
        if (!isEmpty()) {
            return ints[--size];
        }
        return null;
    }

    public Integer top() {
        if (!isEmpty()) {
            return ints[size - 1];
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(ints[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private void resizeArray() {
        if (size > ints.length * 3 / 4) {
            Integer[] tempValues = new Integer[ints.length * 2];
            for (int i = 0; i <= size; i++) {
                tempValues[i] = ints[i];
            }
            ints = tempValues;
        } else if (ints.length > 5 && size < ints.length / 4) {
            Integer[] tempValues = new Integer[ints.length / 2];
            for (int i = 0; i <= size; i++) {
                tempValues[i] = ints[i];
            }
            ints = tempValues;
        }
    }
}
