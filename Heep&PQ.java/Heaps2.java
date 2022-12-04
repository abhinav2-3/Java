import java.util.*;

public class Heaps2 {
    // 1 Heap Sort
    public static void heapify(int arr[], int i, int size) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int minIdx = i;
        if (left < size && arr[left] < arr[minIdx]) {
            minIdx = left;
        }
        if (right < size && arr[right] < arr[minIdx]) {
            minIdx = right;
        }
        if (minIdx != i) {
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

            heapify(arr, minIdx, size);
        }
    }

    public static void heapSort(int arr[]) { // O(nlogn)
        // step 1 - build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) { // O(nlogn)
            heapify(arr, i, n);
        }
        // step 2 - push largest element at end
        for (int i = n - 1; i > 0; i--) { // O(nlogn)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);
        // print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
