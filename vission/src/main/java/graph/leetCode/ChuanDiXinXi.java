package graph.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * LCP 07. 传递信息
 */
public class ChuanDiXinXi {
    /**
     * DFS深度优先遍历
     * @param n
     * @param relation
     * @param k
     * @return
     */
    int ways,n,k;
    List<List<Integer>> edges;
    public int numWays(int n, int[][] relation, int k) {
        ways = 0;
        this.n = n;
        this.k = k;
        //建图
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < relation.length; i++) {
            edges.get(relation[i][0]).add(relation[i][1]);
        }
        dfs(0,0);
        return ways;
    }
    public void dfs(int index,int step){
        if (step==k){
            if (index == n-1){
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (int nextIndex: list) {
            dfs(nextIndex,step+1);
        }
    }
}
