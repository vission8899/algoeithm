package graph.algo;

import graph.pojo.Graph;
import graph.pojo.Node;
import graph.utils.GraphUtils;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.util.*;

/**
 * 广度优先遍历
 */
public class BFS {
    public static List<Node> bfs(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        //防止重复加入
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            //弹出则为当前正在遍历的Node
            Node cur = queue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = GraphUtils.createGraphByIntArr();
        GraphUtils.printlnList(bfs(graph.nodeMap.get(1)));
    }
}
