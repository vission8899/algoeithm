package graph.pojo;


import java.util.ArrayList;

public class Node {
    public int value;
    //关联的点
    public ArrayList<Node> nexts;
    //关联的边
    public ArrayList<Edge> edges;
    //出度
    public Integer out;
    //入度
    public Integer in;
    public Node(int value){
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
        out = 0;
        in = 0;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "value=" + value +
//                ", nexts=" + nexts +
//                ", edges=" + edges +
//                ", out=" + out +
//                ", in=" + in +
//                '}';
//    }
}
