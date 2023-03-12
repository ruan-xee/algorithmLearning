package day07;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashSet<Edge> edges;
    public HashMap<Integer, Node> nodes;

    public Graph() {
        edges = new HashSet<>();
        nodes = new HashMap<>();
    }
}
