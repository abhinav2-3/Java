package GraphPart3;
import java.util.*;

@SuppressWarnings("unchecked")

public class Dijkastra {
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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // path based sorting for pairss
        }
    }

    // Dijksta's Algorithm(Find Shortest path)
    public static void dijkastra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    // Method 2
    static void createGraph2(ArrayList<Edge> graph1) {
        graph1.add(new Edge(0, 1, 2));
        graph1.add(new Edge(0, 2, 4));
        graph1.add(new Edge(1, 2, -4));
        graph1.add(new Edge(2, 3, 2));
        graph1.add(new Edge(3, 4, 4));
        graph1.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph1, int src, int X) {
        int dist[] = new int[X];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < X - 1; i++) {
            for (int j = 0; j < graph1.size(); j++) {
                Edge e = graph1.get(j);
                int u = e.src;
                int v = e.dest;
                int w = e.wt;
                // relaxation
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        // int V = 6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraphs(graph);
        // for (int i = 0; i < graph.length; i++) {
        // graph[i] = new ArrayList<>();
        // }
        int src = 0;
        // dijkastra(graph, src);

        int X = 6; // -> Vertices
        // ArrayList<Edge> graph1[] = new ArrayList[X];
        ArrayList<Edge> graph1 = new ArrayList<>();
        createGraph2(graph1);
        bellmanFord(graph1, src, X);
    }
}