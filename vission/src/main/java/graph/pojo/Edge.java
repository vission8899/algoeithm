package graph.pojo;

import lombok.Data;

@Data
public class Edge {
    Node toNode;
    Node fromNode;
    //权重
    Integer weight;
}
