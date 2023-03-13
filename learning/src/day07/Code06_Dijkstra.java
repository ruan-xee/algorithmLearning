package day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 无负数权重
 */
public class Code06_Dijkstra {
    public static HashMap<Node, Integer> dijkstra1(Node head) {
        // 从head出发到所有点的最小距离
        // key: 从head出发到达key
        // value: 从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从head出发到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        // 从head到head的距离为0
        distanceMap.put(head, 0);
        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                // minNode所连接的另一个点
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {    // else不加也行，如果进了if，那么min函数中两值大小相等，也不会发生更新
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
                                                        HashSet<Node> selectedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
