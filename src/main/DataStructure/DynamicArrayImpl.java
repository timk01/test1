package DataStructure;

import java.util.Objects;

public class DynamicArrayImpl {
    private int nonsence;
    private Integer[] values = new Integer[5]; //hardcode
    private int size = 0; // количество реальных элементов в массиве

/*    public DynamicArrayImpl() {
    }*/

    public void insert(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values[i], item)) {
                return;
            }
        }
        values[size] = item;
        size++;
        resizeArray();
    }

    public Integer get(int index) {
        if (index > size || index < 0) {
            return null;
        }
        return values[index];
    }

    public void delete(int index) {
        if (index < size && index >= 0) {
            for (int i = index; i < size; i++) {
                values[i] = values[i + 1];
            }
            size--;
            resizeArray();
        }
    }

    public int size() {
        return size;
    }

    private void resizeArray() {
        if (size > values.length * 3 / 4) {
            Integer[] tempValues = new Integer[values.length * 2];
            for (int i = 0; i <= size; i++) {
                tempValues[i] = values[i];
            }
            values = tempValues;
        } else if (values.length > 5 && size < values.length / 4) {
            Integer[] tempValues = new Integer[values.length / 2];
            for (int i = 0; i <= size; i++) {
                tempValues[i] = values[i];
            }
            values = tempValues;
        }
    }
}
