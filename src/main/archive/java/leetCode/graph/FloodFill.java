package leetCode.graph;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/flood-fill/">图像渲染</a>
 * #733. 图像渲染
 */
public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        int[][] visitored = new int[image.length][image[0].length];
        FloodFill.dfs(image, sr, sc, newColor, oldColor, visitored);
        return image;
    }

    /**
     * initPoint image[sr][sc] 上:image[sr-1][sc] 下:image[sr+1][sc] 左:image[sr][sc-1] 右:image[sr][sc+1]
     */
    public static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, int[][] visitored) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visitored[sr][sc] > 0
                || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        visitored[sr][sc]++;
        FloodFill.dfs(image, sr - 1, sc, newColor, oldColor, visitored);
        FloodFill.dfs(image, sr + 1, sc, newColor, oldColor, visitored);
        FloodFill.dfs(image, sr, sc - 1, newColor, oldColor, visitored);
        FloodFill.dfs(image, sr, sc + 1, newColor, oldColor, visitored);
    }

    public static void main(String[] args) {
//        System.out.println(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));
        int[][] floodFill = FloodFill.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2);
        System.out.println(Arrays.deepToString(floodFill));
    }
}
