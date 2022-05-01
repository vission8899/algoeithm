package graph.algo;

import graph.pojo.Edge;
import graph.pojo.Graph;
import graph.pojo.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 最小生成树K*算法
 * 边从小到大排序
 * 没有使用并查集，利用集合，判断是否成环
 */
public class Kruskal {
    public static class EdgeCompare implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }
    public Graph kruskal(Graph graph) {
        Graph result = new Graph();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeCompare());
//        HashSet<Node>


        return result;
    }
}
