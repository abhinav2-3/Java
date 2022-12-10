package GraphPart4;
public class Graph8 {
    // flood Fill Algorithm
    // Ques 733 on leetcode
    public void helper(int[][] img, int sr, int sc, int color, boolean vis[][], int OGcolor) {
        if (sr < 0 || sc < 0 || sr >= img.length || sr >= img[0].length || vis[sr][sc]
                || img[sr][sc] != OGcolor) {
            return;
        }
        // left
        helper(img, sr, sc - 1, color, vis, OGcolor);
        // right
        helper(img, sr, sc + 1, color, vis, OGcolor);
        // up
        helper(img, sr - 1, sc, color, vis, OGcolor);
        // down
        helper(img, sr + 1, sc, color, vis, OGcolor);

    }

    public int[][] floodFill(int[][] img, int sr, int sc, int color) {
        boolean vis[][] = new boolean[img.length][img[0].length];
        helper(img, sr, sc, color, vis, color);
        return img;
    }

    public static void main(String[] args) {

    }
}
