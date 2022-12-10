package GraphPart4;
import java.util.*;

public class Graphs7 {

    // static int n = 7;
    // static int rank[] = new int[n];
    // static int par[] = new int[n];

    // public static void init() {
    // for (int i = 0; i < n; i++) {
    // par[i] = i;
    // }1
    // }

    // public static int find(int x) {
    // if (x == par[x]) {
    // return x;
    // }

    // return par[x] = find(par[x]); // Optimisation (Path Compression)
    // }

    // public static void union(int a, int b) {
    // int parA = find(par[a]);
    // int parB = find(par[b]);

    // if (rank[parA] == rank[parB]) {
    // par[parB] = parA;
    // rank[parA]++;
    // } else if (rank[parA] < rank[parB]) {
    // par[parA] = parB;
    // } else {
    // par[parB] = parA;
    // }
    // }

    
    // kruskulsAlgo  (Not worked)
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        } 
    }

    static void createEdge(ArrayList<Edge> edge) {
        edge.add(new Edge(0, 1, 10));
        edge.add(new Edge(0, 2, 15));
        edge.add(new Edge(0, 3, 30));
        edge.add(new Edge(1, 3, 40));
        edge.add(new Edge(2, 3, 50));
    }

    static int n1 = 4; // Vertices
    static int rank1[] = new int[n1];
    static int par1[] = new int[n1];

    public static void init1() {
        for (int i = 0; i < n1; i++) {
            par1[i] = i;
        }
    }

    public static int find1(int x) {
        if (x == par1[x]) {
            return x;
        }

        return par1[x] = find1(par1[x]); // Optimisation (Path Compression)
    }

    public static void union1(int a, int b) {
        int parA = find1(par1[a]);
        int parB = find1(par1[b]);

        if (rank1[parA] == rank1[parB]) {
            par1[parB] = parA;
            rank1[parA]++;
        } else if (rank1[parA] < rank1[parB]) {
            par1[parA] = parB;
        } else {
            par1[parB] = parA;
        }
    }

    public static void kruskulsAlgo(ArrayList<Edge> edge, int V) {
        init1();
        Collections.sort(edge);
        int mstCount = 0;
        int count = 0;

        for (int i = 0; count < edge.size(); i++) {
            Edge e = edge.get(i);
            int parA = find1(e.src);
            int parB = find1(e.dest);
            if (parA != parB) {
                union1(e.src, e.dest);
                mstCount += e.wt;
            }
        }
        System.out.println(mstCount);
    }

    public static void main(String args[]) {
        // init();
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);

        int V = 4;
        ArrayList<Edge> edge = new ArrayList<>();
        createEdge(edge);
       kruskulsAlgo(edge, V);

    }
}
