package leetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/clone-graph/">克隆图</a>
 * #133. 克隆图
 */
public class CloneGraph {

    static class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        map.put(node.val, new Node(node.val, new ArrayList<>()));
        for (int i = 0; i < node.neighbors.size(); i++) {
            map.get(node.val).neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return map.get(node.val);
    }

}
