package opertators_arrays;

public class SredneeArifm {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 15, 20, 23};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int srednee = sum / arr.length;

        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
