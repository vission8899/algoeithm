package leetCode.graph;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode-cn.com/problems/max-area-of-island/">岛屿的最大面积</a>
 * # 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int[][] visitored = new int[grid.length][grid[0].length];
        //大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        //默认值
        priorityQueue.add(0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visitored[i][j] == 0 && grid[i][j] == 1) {
                    priorityQueue.add(MaxAreaOfIsland.bfs(grid, visitored, i, j, 0));
                }
            }
        }
        return priorityQueue.poll();
    }

    public static int bfs(int[][] grid, int[][] visitored, int sr, int sc, int area) {
        if (sr < 0 || sr >= grid.length
                || sc < 0 || sc >= grid[0].length
                || visitored[sr][sc] == 1
                || grid[sr][sc] == 0) {
            return area;
        }
        visitored[sr][sc]++;
        area++;
        area += MaxAreaOfIsland.bfs(grid, visitored, sr - 1, sc, 0)
                + MaxAreaOfIsland.bfs(grid, visitored, sr + 1, sc, 0)
                + MaxAreaOfIsland.bfs(grid, visitored, sr, sc - 1, 0)
                + MaxAreaOfIsland.bfs(grid, visitored, sr, sc + 1, 0);
        return area;
    }

    public static void main(String[] args) {
        System.out.println(
                MaxAreaOfIsland.maxAreaOfIsland(new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                })
        );
    }
}
