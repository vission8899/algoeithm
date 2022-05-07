package graph.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * # 1162. 地图分析
 */
public class AsFarFromIandAsPossible {
    public static int maxDistance(int[][] grid) {
        //x坐标上下左右
        int[] dx = new int[]{-1, 1, 0, 0};
        //y坐标上下左右
        int[] dy = new int[]{0, 0, -1, 1};
        //n*n的矩阵

        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                point = queue.poll();
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] > 0) {
                        continue;
                    }
                    grid[newX][newY] = grid[x][y] + 1;
                    hasOcean = true;
                    queue.add(new int[]{newX, newY});
                }
                size--;
            }
        }
        if (point == null || !hasOcean) {
            return -1;
        }
        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));

    }
}
