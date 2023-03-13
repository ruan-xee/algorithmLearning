package day07;

import java.util.*;

/**
 * 无向图K算法简易版（无并查集）
 *
 * 先将所有点看作一个个单独的集合
 * 再将所有边依照权重，从小到大排序放入队列中
 * 依次取出队列中的边，查看比较该边的两个点是否在同一集合之中，
 * 如果存在同一集合之中，说明加上该边后会形成环路，所以不能加上
 * 如果不在同一集合之中，说明该边连通新点，合并这两个点所在的集合
 * 将边权重队列遍历完，得到最小权重的连通图所有节点的边
 */
public class Code04_Kruskal {

    public static class MySets {
        public HashMap<Node, List<Node>> setMap;
        public MySets(List<Node> nodes) {
            for (Node node : nodes) {   // 将每个点都建立一个只含自身节点的set
                List<Node> set = new ArrayList<>();
                set.add(node);
                setMap.put(node, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node node : toSet) {
                fromSet.add(node);
                setMap.put(node, fromSet);
            }
        }
    }

    public static Set<Edge> KruskalMST(Graph graph) {
        MySets mySets = new MySets((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Edge.EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!mySets.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                mySets.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
