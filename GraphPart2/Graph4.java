package GraphPart2;
import java.util.*;
import java.util.LinkedList;

@SuppressWarnings("unchecked")

public class Graph4 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraphs(ArrayList<Edge> graph[]) { // O(V+E)
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
    }

    // 1 Bipirtite
    public static boolean isBiPartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // No Color
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0; // 0-> Yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // Cycle Detection using Modified DFS
    static void createGraphs2(ArrayList<Edge> graph2[]) { // O(V+E)
        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = new ArrayList<>();
        }

        graph2[0].add(new Edge(0, 2));

        graph2[1].add(new Edge(1, 0));

        graph2[2].add(new Edge(2, 3));

        graph2[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph2) {
        boolean vist[] = new boolean[graph2.length];
        boolean stack[] = new boolean[graph2.length];
        for (int i = 0; i < graph2.length; i++) {
            if (!vist[i]) {
                if (isCycleUtil(graph2, i, vist, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph2, int curr, boolean vist[], boolean stack[]) {
        vist[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph2[curr].size(); i++) {
            Edge e = graph2[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!vist[e.dest] && isCycleUtil(graph2, e.dest, vist, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraphs(graph);
        // System.out.println(isBiPartite(graph));

        ArrayList<Edge> graph2[] = new ArrayList[V];
        createGraphs(graph2);
        System.out.println(isCycle(graph2));
    }
}
