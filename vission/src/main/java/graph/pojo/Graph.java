package graph.pojo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 */
public class Graph {
    //图中的点
    public HashMap<Integer, Node> nodeMap;
    //图中的边
    public HashSet<Edge> edges;
    public Graph(){
        nodeMap = new HashMap<>();
        edges = new HashSet<>();
    }
}
