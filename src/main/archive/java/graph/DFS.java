package graph;

import graph.dataStructure.Graph;
import graph.dataStructure.Node;
import graph.utils.GraphUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

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
        HashSet<Node> visited = new HashSet<>();
        stack.add(node);
        visited.add(node);
        nodes.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
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
        GraphUtils.printlnList(DFS.dfs(graph.nodeMap.get(1)));
    }
}
