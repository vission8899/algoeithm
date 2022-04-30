package graph.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 图
 */
@Data
public class Graph {
    //图中的点
    HashMap<Integer, Node> nodeMap;
    //图中的边
    Set<Edge> edges;
}
