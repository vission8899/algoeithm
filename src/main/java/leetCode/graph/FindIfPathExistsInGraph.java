package leetCode.graph;

import graph.DFS;
import graph.dataStructure.Graph;
import graph.dataStructure.Node;
import graph.utils.GraphUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/find-if-path-exists-in-graph/">寻找图中是否存在路径</a>
 * #1971 寻找图中是否存在路径
 */
public class FindIfPathExistsInGraph {

    /**
     * 判断是否在一个集合里
     *
     * @param n           节点数
     * @param edges       边
     * @param source      起点
     * @param destination 终点
     * @return 是否存在路径
     */
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> list = new HashSet<>();
            list.add(i);
            map.put(i, list);
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> fromSet = map.get(from);
            Set<Integer> toSet = map.get(to);
            for (Integer cur : toSet) {
                fromSet.add(cur);
                map.put(cur, fromSet);
            }
        }

        return map.get(source) == map.get(destination);
    }


    /**
     * BFS算法 遍历到了返回true
     *
     * @param n           节点数
     * @param edges       边
     * @param source      起点
     * @param destination 终点
     * @return 是否存在路径
     */
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
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
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == destination) {
                return true;
            }
            for (Integer integer : map.get(x)) {
                if (!hashSet.contains(integer)) {
                    hashSet.add(integer);
                    queue.add(integer);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Graph graph = GraphUtils.createGraphByIntArr(new int[][]{{0, 1}, {1, 2}, {2, 0}});
        List<Node> dfs = DFS.dfs(graph.nodeMap.get(0));
        System.out.println(dfs);
//        System.out.println(validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
    }
}
