package leetCode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/chuan-di-xin-xi/">传递信息</a>
 * LCP 07. 传递信息
 */
public class ChuanDiXinXi {

    List<List<Integer>> edges;
    int ways, n, k;

    /**
     * DFS深度优先遍历
     *
     * @param n        人数
     * @param relation 信任数组
     * @param k        传递次数
     * @return 传递次数
     */
    public int numWays(int n, int[][] relation, int k) {
        ways = 0;
        this.n = n;
        this.k = k;
        //建图
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] ints : relation) {
            edges.get(ints[0]).add(ints[1]);
        }
        dfs(0, 0);
        return ways;
    }

    public void dfs(int index, int step) {
        if (step == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (int nextIndex : list) {
            dfs(nextIndex, step + 1);
        }
    }
}
