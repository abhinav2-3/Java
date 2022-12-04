

package Sorting;
import java.util.Arrays;
import java.util.Collections;

public class BasicSorting {

    public static void Bubblesorting(int arr[]) {
        int swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
        }
        System.out.println("No. of swap = " + swap);
    }

    public static void printarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void Selectionsort(int arr[]) {
        int swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minpos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minpos] > arr[j]) {
                    minpos = j;
                }
            }
            // swap
            int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
            swap++;
        }
        System.out.println("No. of swap = " + swap);
    }

    // [INSERSTION SORT]
    public static void Inserstionsort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i], prevs = i - 1;
            // finding out currect position to insert
            while (prevs >= 0 && arr[prevs] > curr) {
                arr[prevs + 1] = arr[prevs];
                prevs--;
            }
            // Insertion
            arr[prevs + 1] = curr;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void countingsort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;

            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 3, 0, 4, 2 };
        // Bubblesorting(arr);
        // Selectionsort(arr);
        // Inserstionsort(arr);
        countingsort(arr);
        // Arrays.sort(arr, 0, 4); ---->> For Ascending order

        // Arrays.sort(arr, Collections.reverseOrder()); // ---->> For Descending order
        printarray(arr);
    }
}