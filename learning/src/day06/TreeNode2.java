package day06;

public class TreeNode2<T> {
    public T value;
    public TreeNode2<T> left;
    public TreeNode2<T> right;
    public TreeNode2<T> parent;

    public TreeNode2(T value) {
        this.value = value;
    }

    // 求某一个树节点的后继节点
    // 后继节点指树按照中序遍历的顺序，它的下一个输出节点即为后继节点，最后一个节点的后继节点为null

    public static TreeNode2<Integer> getSuccessorNode(TreeNode2<Integer> node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {   // 说明有右子树
            return getLeftMost(node.right);
        } else {                    // 说明无右子树
            TreeNode2<Integer> parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static TreeNode2<Integer> getLeftMost(TreeNode2<Integer> node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
