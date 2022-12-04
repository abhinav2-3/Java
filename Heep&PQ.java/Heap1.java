import java.util.*;

public class Heap1 {

    // Insert in heap
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add at last idx
            arr.add(data);
            int x = arr.size() - 1; // x is child index
            int par = (x - 1) / 2; // parents index

            while (arr.get(x) > arr.get(par)) { // O(log n)
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        // Heapify
        private void heapify(int i) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) < arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) < arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        // Delete heap
        public int remove() {
            int data = arr.get(0);

            // step 1
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2 delete last heap
            arr.remove(arr.size() - 1);

            // step 3 heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(1);
        pq.add(7);
        pq.add(3);
        pq.add(6);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}