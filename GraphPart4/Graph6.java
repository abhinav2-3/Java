package GraphPart4;
import java.util.*;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class Graph6 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraphs(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 30));
        graph[0].add(new Edge(0, 2, 15));

        graph[1].add(new Edge(1, 3, 40));
        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // path based sorting for pairss
        }
    }

    // Minimum Spanning Tree(MST)

    public static void prims(ArrayList<Edge> graph[]) { // O(ElogE)
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("Final cos(Min) is : " + finalCost);
    }

    // Min. Flight Price
    public static void creategraph1(int flight[][], ArrayList<Edge> graph1[]) {
        for (int i = 0; i < graph1.length; i++) {
            graph1[i] = new ArrayList<>();
        }
        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];

            Edge e = new Edge(src, dest, wt);
            graph1[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stop;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }

    public static int cheapestFlight(int n, int flight[][], int src, int dest, int k) {
        ArrayList<Edge> graph1[] = new ArrayList[n];
        creategraph1(flight, graph1);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stop > k) {
                break;
            }

            for (int i = 0; i < graph1[curr.v].size(); i++) {
                Edge e = graph1[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stop <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stop + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    // Connect Cities in Min. Cost
    static class Edge1 implements Comparable<Edge1> {
        int dest;
        int cost;

        public Edge1(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge1 e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge1> pq1 = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq1.add(new Edge1(0, 0));
        int finalCost = 0; 

        while (!pq1.isEmpty()) {
            Edge1 curr = pq1.remove();  
             
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq1.add(new Edge1(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraphs(graph);
        // prims(graph);

        int n = 4;
        int flight[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 300 } };
        int src = 0, dest = 3, k = 1;
        // System.out.println(cheapestFlight(n, flight, src, dest, k));

        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };
        System.out.println(connectCities(cities));
    }
}