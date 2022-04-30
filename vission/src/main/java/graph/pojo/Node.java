package graph.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Node {
    String value;
    //关联的点
    List<Node> nextNode;
    //关联的边
    List<Edge> nextEdge;
    //出度
    Integer out;
    //入度
    Integer in;
}
