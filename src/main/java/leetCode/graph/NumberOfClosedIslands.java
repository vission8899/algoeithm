package leetCode.graph;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-closed-islands/">统计封闭岛屿的数目</a>
 * # 1254. 统计封闭岛屿的数目
 */
public class NumberOfClosedIslands {

    public static int closedIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 0) {
                    if (NumberOfClosedIslands.bfs(visited, grid, i, j)) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    /**
     * @param visited 访问过的节点
     * @param grid    岛屿
     * @param sr      起始行
     * @param sc      起始列
     * @return 是否是封闭岛屿
     */
    public static boolean bfs(int[][] visited, int[][] grid, int sr, int sc) {
        if (sr < 0 || sr >= grid.length
                || sc < 0 || sc >= grid[0].length

        ) {
            return false;
        }
        if (visited[sr][sc] == 1 || grid[sr][sc] == 1) {
            return true;
        }
        visited[sr][sc]++;
        boolean flag = true;
        flag = flag & NumberOfClosedIslands.bfs(visited, grid, sr - 1, sc)
                & NumberOfClosedIslands.bfs(visited, grid, sr + 1, sc)
                & NumberOfClosedIslands.bfs(visited, grid, sr, sc - 1)
                & NumberOfClosedIslands.bfs(visited, grid, sr, sc + 1);
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfClosedIslands.closedIsland(
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
