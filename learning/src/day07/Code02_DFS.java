package day07;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Code02_DFS {
    // 从node出发，进行深度优先遍历
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        set.add(node);
        stack.add(node);

        System.out.println(node.value);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    stack.add(cur);
                    stack.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
