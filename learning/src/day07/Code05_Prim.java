package day07;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 无向图的Prim算法
 * 随意找一个出发点，将该点加入已找集合set中，并解锁该点所有的边，依照权重大小加入queue，
 * 从queue中取一条最小边，查看该边的两个点是否在集合set中，
 * 如果存在，说明该点已经经过，不采纳，
 * 如果不存在，说明该点未经过，采纳这条边，解锁该点所有的边加入queue，将点加入set
 * 最后返回所有被采纳的边
 */
public class Code05_Prim {
    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Edge.EdgeComparator());
        HashSet<Node> set = new HashSet<>();        // 考察过的点放入
        HashSet<Edge> result = new HashSet<>();

        for (Node node : graph.nodes.values()) {    // 为了防止出现图不连通问题，找到下一个连通点
            if (!set.contains(node)) {              // 说明该点未被考察过
                set.add(node);
                queue.addAll(node.edges);
                while (!queue.isEmpty()) {
                    Edge cur = queue.poll();

                    /*
                    这里是无向图，所以不一定是to点表示另一端，
                    所以我感觉应该判断这条边的两端node是否在set中，
                    如果都在set中说明该边已经使用过，
                    如果有一端没在set中，所以那个点未到达过，
                    应该不会有两端都不在set中的情况，毕竟这里的边添加都是由一个点解锁出来的
                     */
                    Node toNode = cur.to;


                    if (!set.contains(toNode)) {    // 该目标点未到达过
                        set.add(toNode);
                        result.add(cur);
                        queue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }
}
