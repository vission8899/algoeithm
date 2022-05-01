package graph.algo;

import graph.pojo.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * 深度优先
 */
public class DFS {
    public static List<Node> dfs(Node node) {
        if (node == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        HashSet<Node> hashSet = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        hashSet.add(node);
        list.add(node);
        while (!stack.empty()){
            Node t = stack.pop();
            for (Node n : t.nexts){
                if (!hashSet.contains(n)){
                    stack.add(t);
                    stack.add(n);
                    hashSet.add(n);
                    list.add(n);
                    break;
                }
            }
        }
        return list;
    }
}
