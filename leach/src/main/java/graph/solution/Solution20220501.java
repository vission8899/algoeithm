package graph.solution;

import java.util.*;

/**
 * 算法题目练习
 */
public class Solution20220501 {

    /**
     *小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
     *
     * 如果小镇法官真的存在，那么：
     *
     * 小镇法官不会信任任何人。
     * 每个人（除了小镇法官）都信任这位小镇法官。
     * 只有一个人同时满足属性 1 和属性 2 。
     * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
     *
     * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
     *
     *  
     * 解题逻辑：转换为出度和入度结构，使用出度=0和入度=n-1 判断
     */
    public int findJudge(int N, int[][] trust) {
        int[][] people = new int[N][2];
        for(int[] person : trust){
            int out = person[0];
            int in = person[1];
            people[out - 1][0] ++;
            people[in - 1][1] ++;
        }
        for(int i = 0; i < N; i ++){
            if(people[i][0] == 0 && people[i][1] == N - 1)
                return i + 1;
        }
        return -1;
    }

    /**
     * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
     *
     * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
     *
     * 解题逻辑：所有边都包含的节点
     */
    public int findCenter(int[][] edges) {
        int x = edges[0][0];
        for (int  i = 0 ; i< edges.length; i++) {
            if (x != edges[i][0] && x!=edges[i][1]){
                break;
            }
            if (i == edges.length-1){
                return x;
            }
        }
        return edges[0][1];
    }

    /**
     * 有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
     *
     * 请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。
     *
     * 给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。
     *
     * 解题逻辑：从起点开始遍历，能够遍历到终点即可返回true，本次采用广度优先遍历
     */

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination){
            return true;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        hashSet.add(source);
        queue.add(source);
        while (!queue.isEmpty()){
            int x = queue.poll();
            if (x==destination){
                return true;
            }
            for (Integer integer : map.get(x)){
                if (!hashSet.contains(integer)){
                    hashSet.add(integer);
                    queue.add(integer);
                }
            }
        }
        return false;
    }

    /**
     * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
     *
     * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
     * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
     * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
     * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
     *
     * 解题逻辑：采用动态规划的方式
     */
    public int numWays(int n, int[][] relation, int k) {
        int [][]dp=new int [k+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<k;i++){
            for(int [] line:relation){
                int source=line[0];
                int destination=line[1];
                dp[i+1][destination]+=dp[i][source];
            }
        }
        return dp[k][n-1];
    }


}
