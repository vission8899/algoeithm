package graph.utils;

import graph.pojo.Edge;
import graph.pojo.Graph;
import graph.pojo.Node;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 图初始化工具
 */
public class GraphUtils {
    public static int[][] getGraphArr() {
        return new int[][]{
                {1, 2, 1},
                {2, 1, 1},
                {1, 3, 2},
                {3, 1, 2},
                {1, 4, 4},
                {4, 1, 4},
                {2, 3, 3},
                {3, 2, 3},
                {2, 4, 5},
                {4, 2, 5},
                {3, 4, 6},
                {4, 3, 6}
        };
    }

    public static int[][] getGraphArrByTopo() {
        return new int[][]{
                {1, 2, 0},
                {1, 3, 0},
                {2, 3, 0},
                {2, 4, 0},
                {3, 4, 0}
        };
    }

    public static Graph createGraphByIntArr(int[][] graphArr) {
        Graph graph = new Graph();
        for (int i = 0; i < graphArr.length; i++) {
            int from = graphArr[i][0];
            int to = graphArr[i][1];
            int weight = 0;
            try {
                weight = graphArr[i][2];
            } catch (Exception e) {

            }
            if (!graph.nodeMap.containsKey(to)) {
                graph.nodeMap.put(to, new Node(to));
            }
            if (!graph.nodeMap.containsKey(from)) {
                graph.nodeMap.put(from, new Node(from));
            }
            Node toNode = graph.nodeMap.get(to);
            Node fromNode = graph.nodeMap.get(from);
            Edge newEdge = new Edge(toNode, fromNode, weight);
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            fromNode.out++;
            toNode.in++;
            graph.edges.add(newEdge);
        }
        return graph;
    }

    /**
     * 打印List
     */
    public static void printlnList(List<Node> nodes) {
        if (nodes.isEmpty()) {
            System.out.println("List is empty");
        }
        for (Node node : nodes) {
            System.out.println(node.toString());
        }
    }
}
