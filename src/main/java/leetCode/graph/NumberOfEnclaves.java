package leetCode.graph;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-enclaves/">飞地的数量</a>
 * # 1020. 飞地的数量
 */
public class NumberOfEnclaves {

    public static int numEnclaves(int[][] grid) {
        int[][] visitored = new int[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visitored[i][j] == 0) {
                    int area = NumberOfEnclaves.bfs(visitored, grid, i, j);
                    if (area > 0) {
                        num += area;
                    }
                }
            }
        }
        return num;
    }

    public static int bfs(int[][] visitored, int[][] grid, int sr, int sc) {
        if (sr < 0 || sr >= grid.length
                || sc < 0 || sc >= grid[0].length) {
            return -1;
        }
        if (visitored[sr][sc] == 1 || grid[sr][sc] == 0) {
            return 0;
        }
        visitored[sr][sc]++;
        int area = 1;
        int up = NumberOfEnclaves.bfs(visitored, grid, sr - 1, sc);
        int down = NumberOfEnclaves.bfs(visitored, grid, sr + 1, sc);
        int left = NumberOfEnclaves.bfs(visitored, grid, sr, sc - 1);
        int right = NumberOfEnclaves.bfs(visitored, grid, sr, sc + 1);
        if (up == -1 || down == -1
                || left == -1 || right == -1) {
            return -1;
        }
        area = area + up + down + left + right;
        return area;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfEnclaves.numEnclaves(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        }));
    }
}
