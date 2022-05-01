package graph.algo;

import graph.pojo.Node;

import java.util.*;

/**
 * 广度优先
 */
public class BFS {
    public static List<Node> bfs(Node node) {
        if (node == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        HashSet<Node> hashSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        hashSet.add(node);
        queue.add(node);
        while (!queue.isEmpty()){
            Node t = queue.poll();
            list.add(t);
            for (Node n : t.nexts){
                if (!hashSet.contains(n)){
                    queue.add(n);
                    hashSet.add(n);
                }
            }
        }

        return list;
    }
}
