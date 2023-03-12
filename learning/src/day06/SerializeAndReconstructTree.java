package day06;

import day05.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 序列化和反序列化一棵树
 */
public class SerializeAndReconstructTree {

    // 先序遍历方式进行序列化
    public static String serialByPre(TreeNode<Integer> head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    // 将先序遍历得到的序列化进行反序列化操作
    public static TreeNode<Integer> reconByPreString(String preStr) {
        String[] strArr = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strArr.length; i++) {
            queue.add(strArr[i]);
        }
        return reconPreOrder(queue);
    }

    private static TreeNode<Integer> reconPreOrder(Queue<String> queue) {
        String poll = queue.poll();
        if (Objects.equals(poll, "#")){
            return null;
        }
        TreeNode<Integer> node = new TreeNode<>(Integer.valueOf(poll));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }
}
