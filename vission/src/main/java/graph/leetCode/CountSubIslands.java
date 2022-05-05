package graph.leetCode;

/**
 * https://leetcode-cn.com/problems/count-sub-islands/
 * # 1905. 统计子岛屿
 */
public class CountSubIslands {
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] visitor = new int[grid2.length][grid2[0].length];
        int num = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (visitor[i][j] == 0 && grid2[i][j] == 1) {
                    if (bfs(grid1, grid2, visitor, i, j)) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public static boolean bfs(int[][] grid1, int[][] grid2, int[][] visitor, int sr, int sc) {
        if (sr < 0 || sr >= grid2.length || sc < 0 || sc >= grid2[0].length||
                grid2[sr][sc] == 0 || visitor[sr][sc] == 1) {
            return true;
        }
        visitor[sr][sc]++;
        boolean flag = true;
        flag = flag &
                grid1[sr][sc] == 1 &
                bfs(grid1, grid2, visitor, sr - 1, sc) &
                bfs(grid1, grid2, visitor, sr + 1, sc) &
                bfs(grid1, grid2, visitor, sr, sc - 1) &
                bfs(grid1, grid2, visitor, sr, sc + 1);
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(countSubIslands(
                new int[][]{
                        {1, 1, 1, 0, 0},
                        {0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1}},
                new int[][]{
                        {1, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1},
                        {0, 1, 0, 0, 0},
                        {1, 0, 1, 1, 0},
                        {0, 1, 0, 1, 0}}));
    }
}
