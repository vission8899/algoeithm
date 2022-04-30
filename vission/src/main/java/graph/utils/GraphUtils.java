package graph.utils;

import graph.pojo.Edge;
import graph.pojo.Graph;
import graph.pojo.Node;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 图初始化工具
 */
public class GraphUtils {
    public static int[][] getGraphArr(){
        return new int[][]{{1,2,1},{2,1,1},{1,3,2},{3,1,2},{1,4,4},{4,1,4},{2,3,3},{3,2,3},{2,4,5},{4,2,5},{3,4,6},{4,3,6}};
    }
    public static Graph createGraphByIntArr(){
        int[][] graphArr = getGraphArr();
        Graph graph = new Graph();
        for (int i = 0; i < graphArr.length; i++) {
            int to = graphArr[i][0];
            int from = graphArr[i][1];
            int weight = graphArr[i][2];
            if (!graph.nodeMap.containsKey(to)){
                graph.nodeMap.put(to,new Node(to));
            }
            if (!graph.nodeMap.containsKey(from)){
                graph.nodeMap.put(from,new Node(from));
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
    public static void printlnList(List<Node> nodes){
        if (nodes.isEmpty()){
            System.out.println("List is empty");
        }
        System.out.println(nodes.toString());
    }
}
