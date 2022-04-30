package graph.pojo;

public class Edge {
    public Node toNode;
    public Node fromNode;
    //权重
    public Integer weight;
    public Edge(Node fromNode, Node toNode, Integer weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }
}
