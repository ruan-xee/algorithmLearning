package day08;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有若干个项目，记录它们所需的本金及利润
 * 现在给你一定的初始本金及你所能做的项目次数
 * 问：你最终能有多少钱
 */
public class Code05_IPO {
    public static class Node {
        public int p;   // 利润
        public int c;   // 花销

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    // 最小本金比较器
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    // 最大利润比较器
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        // 所有项目扔进被锁池中，花费组织的小根堆
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Node(Profits[i], Capital[i]));
        }
        for (int i = 0; i < k; i++) {   // 进行K轮
            // 能力所及的项目，解锁放进大根堆中
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
