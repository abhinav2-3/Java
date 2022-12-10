package GraphPart3;
import java.util.*;
import java.util.LinkedList;

@SuppressWarnings("unchecked")

public class graph5 {
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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // TropoLogical Sorting Using BFS
    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        // BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // #2 All path from src to target O(v^v) Exponential

    static void createGraphs1(ArrayList<Edge> graph1[]) {
        for (int i = 0; i < graph1.length; i++) {
            graph1[i] = new ArrayList<>();
        }
        graph1[0].add(new Edge(0, 3));
        graph1[2].add(new Edge(2, 3));

        graph1[3].add(new Edge(3, 1));

        graph1[4].add(new Edge(4, 0));
        graph1[4].add(new Edge(4, 1));

        graph1[5].add(new Edge(5, 0));
        graph1[5].add(new Edge(5, 2));
    }

    public static void printAllPath(ArrayList<Edge> graph1[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
        }

        for (int i = 0; i < graph1[src].size(); i++) {
            Edge e = graph1[src].get(i);
            printAllPath(graph1, e.dest, dest, path + src);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraphs(graph);
        // topSort(graph);

        // #2
        int X = 8;
        ArrayList<Edge> graph1[] = new ArrayList[X];
        createGraphs(graph1);
        int src = 5, dest = 3;
        printAllPath(graph1, src, dest, "");
    }
}
