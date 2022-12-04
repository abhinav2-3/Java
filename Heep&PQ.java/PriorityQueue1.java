import java.util.*;

public class PriorityQueue1 {

    static class student implements Comparable<student> { // Overriding
        String name;
        int rank;

        public student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(student s2) {
            return this.rank - s2.rank;
        }
    }

    // #1 -> Find Nearest Car
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // pq.add(new student("A", 4)); // O(log n)
        // pq.add(new student("B", 31));
        // pq.add(new student("C", 5));
        // pq.add(new student("D", 23));
        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek().name + " -> " + pq.peek().rank); // O(1)
        // pq.remove();
        // }

        // #2
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            System.out.println("(" + pts[i][0] + "," + pts[i][1] + ")");

            int distSq = (int) Math.sqrt(pts[i][0] * pts[i][0] + pts[0][1] * pts[0][1]);

            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }
        // nearest K cars
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }
}
