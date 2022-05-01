package graph.pojo;

import lombok.Data;

@Data
public class Edge {
    //终点
    public Node toNode;
    //起点
    public Node fromNode;
    //权重
    public Integer weight;
    public Edge(Node fromNode, Node toNode, Integer weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }
}