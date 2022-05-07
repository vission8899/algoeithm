package leetCode.graph;

/**
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 * #1791.找到星图中心节点
 */
public class FindCenterOfStarGraph {
    public static int findCenter(int[][] edges) {
        int n = edges.length+1;
        int nodeArr[] = new int[n];
        for (int[] arr:edges) {
            nodeArr[arr[0]-1]++;
            nodeArr[arr[1]-1]++;
        }
        for (int i = 0; i < n; i++) {
            if (nodeArr[i] == n-1) {
                return i+1;
            }
        }
        return -1;
    }

    /**
     * 根据星图的特性
     * 如果edges[0][0] == edges[1]的一个点则中心点是 edges[0][0] 否则是edges[0][1];
     * @param edges
     * @return
     */
    public static int findCenterByOther(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(edges));
    }
}
