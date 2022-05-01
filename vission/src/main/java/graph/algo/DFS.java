package graph.algo;

import graph.pojo.Graph;
import graph.pojo.Node;
import graph.utils.GraphUtils;

import java.util.*;

/**
 * 深度优先遍历
 */
public class DFS {
    public static List<Node> dfs(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        HashSet<Node> visited = new HashSet();
        stack.add(node);
        visited.add(node);
        nodes.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next:cur.nexts) {
                if (!visited.contains(next)) {
                    stack.add(cur);
                    stack.add(next);
                    visited.add(next);
                    nodes.add(next);
                    break;
                }
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        Graph graph = GraphUtils.createGraphByIntArr(GraphUtils.getGraphArr());
        GraphUtils.printlnList(dfs(graph.nodeMap.get(1)));
    }
}
