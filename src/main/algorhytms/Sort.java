package algorhytms;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Timur Khasmamedov (well, not only)
 * @see <a href="https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/visualize/">...</a>
 * @see <a href="https://www.hackerearth.com/practice/algorithms/sorting/insertion-sort/visualize/">...</a>
 * @see <a href="https://forkettle.ru/vidioteka/programmirovanie-i-set/algoritmy-i-struktury-dannykh/108-sortirovka-i-poisk-dlya-chajnikov/1008-sortirovka-shella">...</a>
 * @version 1.5
 * @since   2022-09-13
 */

public class Sort {
    public static void main(String[] args) {
        int[] arr = generate(10, -5, +5);
        long start = System.currentTimeMillis();
        Arrays.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Standart sort alg: " + (end - start));

        //bubbleTest

        start = System.currentTimeMillis();
        arr = generate(10, -5, +5);
        System.out.println("before bubble: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("after bubble: " + Arrays.toString(arr));
        end = System.currentTimeMillis();
        System.out.println("Standart sort alg: " + (end - start));

        //bubbleTest

        start = System.currentTimeMillis();
        arr = new int[]{3, 5, 4, 1};
        System.out.println("before insertion: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("after insertion: " + Arrays.toString(arr));
        end = System.currentTimeMillis();
        System.out.println("Standart sort alg: " + (end - start));

        //shellSort

        arr = new int[]{12, 34, 54, 2, 3};
        System.out.println("Array before sorting");
        printArray(arr);
        shellSort(arr);
        System.out.println("Array after sorting");
        printArray(arr);

    }

    static int[] generate(int length, int minValue, int maxValue) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(maxValue - minValue + 1) + minValue;
        }
        return arr;
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    static int[] shellSort(int arr[]) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        return arr;
    }
}
