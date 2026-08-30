package graph;

import graph.dataStructure.Graph;
import graph.dataStructure.Node;
import graph.utils.GraphUtils;

import java.util.*;

/**
 * 拓扑排序
 */
public class TopoSort {
    public static List<Node> topoSort(Graph graph) {
        Queue<Node> zeroInQueue = new LinkedList<>();
        Map<Node, Integer> inMap = new HashMap<>();
        for (Node node : graph.nodeMap.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                //每弹出一个则与弹出的点相关的点入度减1
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = GraphUtils.createGraphByIntArr(GraphUtils.getGraphArrByTopo());
        GraphUtils.printlnList(topoSort(graph));
    }
}
