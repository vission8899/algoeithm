package graph.leetCode;

/**
 * https://leetcode-cn.com/problems/number-of-closed-islands/
 * # 1254. 统计封闭岛屿的数目
 */
public class NumberOfClosedIslands {
    public static int closedIsland(int[][] grid) {
        int[][] visitored = new int[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && visitored[i][j] == 0) {
                    if (bfs(visitored, grid, i, j)) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    /**
     * @param visitored
     * @param grid
     * @param sr
     * @param sc
     * @return
     */
    public static boolean bfs(int[][] visitored, int[][] grid, int sr, int sc) {
        if (sr < 0 || sr >= grid.length
                || sc < 0 || sc >= grid[0].length

        ) {
            return false;
        }
        if (visitored[sr][sc] == 1||grid[sr][sc] == 1){
            return true;
        }
        visitored[sr][sc]++;
        boolean flag = true;
        flag = flag & bfs(visitored, grid, sr - 1, sc)
                & bfs(visitored, grid, sr + 1, sc)
                & bfs(visitored, grid, sr, sc - 1)
                & bfs(visitored, grid, sr, sc + 1);
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(closedIsland(
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0}
                }
        ));
    }
}
