package graph.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;

@Data
public class Graph {
    //图中的点
    public HashMap<String, Node> nodeMap;
    //图中的边
    public HashSet<Edge> edges;
    public Graph(){
        nodeMap = new HashMap<>();
        edges = new HashSet<>();
    }
}
