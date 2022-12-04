import java.util.*;

public class PriorityQueue2 {
    // # 2 -> Connect ropes in Min Cost
    public static void connectRopes(PriorityQueue<Integer> pq, int ropes[]) {
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }
        System.out.println("Cost of connecting ropes : " + cost);
    }

    // #3 -> Weakest soilders (No resul / something wrong in it)
    static class row implements Comparable<row> {
        int soilders;
        int idx;

        public row(int soilders, int idx) {
            this.soilders = soilders;
            this.idx = idx;
        }

        @Override
        public int compareTo(row r2) {
            if (this.soilders == r2.soilders) {
                return this.idx - r2.idx;
            } else {
                return this.soilders - r2.soilders;
            }
        }
    }

    public static void main(String[] args) {
        // int ropes[] = { 4, 3, 6, 2, 3 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // connectRopes(pq, ropes);

        // #2 (No resul / something wrong in it)
        int army[][] = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };
        int k = 2;

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new row(count, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().idx);
        }
    }
}
