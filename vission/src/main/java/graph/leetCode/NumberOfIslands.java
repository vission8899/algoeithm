package graph.leetCode;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 200. 岛屿数量
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int num = 0 ;
        int[][] visitored = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visitored[i][j]==0&&grid[i][j]=='1'){
                    bfs(grid,visitored,i,j);
                    num++;
                }
            }
        }
        return num;
    }
    public static void bfs(char[][] grid ,int[][] visitored,int sr,int sc){
        if (sr < 0 || sc < 0 || sr>= grid.length ||
                sc >= grid[0].length||
                visitored[sr][sc] != 0||
                grid[sr][sc] == '0'){
            return ;
        }
        visitored[sr][sc]++;
        bfs(grid,visitored,sr-1,sc);
        bfs(grid,visitored,sr+1,sc);
        bfs(grid,visitored,sr,sc-1);
        bfs(grid,visitored,sr,sc+1);
    }

    public static void main(String[] args) {
//        System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        System.out.println(numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
