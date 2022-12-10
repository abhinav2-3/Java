package GraphPart2;
import java.util.*;

@SuppressWarnings("unchecked")

public class Graph3 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraphs(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // Detect cycle by BFS method
    // O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // Case 1
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // case 2 -> Continue
        }
        return false;
    }

    // #4
    static void createGraphs2(ArrayList<Edge> graph2[]) {
        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = new ArrayList<>();
        }

        graph2[2].add(new Edge(2, 3));

        graph2[3].add(new Edge(3, 1));

        graph2[4].add(new Edge(4, 0));
        graph2[4].add(new Edge(4, 1));

        graph2[5].add(new Edge(5, 0));
        graph2[5].add(new Edge(5, 2));
    }
// TopoLogical Sorting
    public static void topSort(ArrayList<Edge>[] graph2) {
        boolean vis[] = new boolean[graph2.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph2.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph2, i, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph2, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph2[curr].size(); i++) {
            Edge e = graph2[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph2, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraphs(graph);
        // System.out.println(detectCycle(graph));

        int v = 6;
        ArrayList<Edge> graph2[] = new ArrayList[v];
        createGraphs2(graph2);
        topSort(graph2);

    }
}
