package day13;

public class Code01_MorrisTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 基础递归遍历
     * @param head
     */
    public static void process(Node head) {
        if (head == null) {
            return;
        }
        // 1
        process(head.left);
        // 2
        process(head.right);
        // 3
    }

    /**
     * morris遍历
     */
    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;   // mostRight是cur左孩子
            if (mostRight != null) {    // 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) {  // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {                        // 第二次来到cur
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    /**
     * morris先序遍历
     */
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;   // mostRight是cur左孩子
            if (mostRight != null) {    // 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) {  // 第一次来到cur
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {                        // 第二次来到cur
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    /**
     * morris中序遍历
     */
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;   // mostRight是cur左孩子
            if (mostRight != null) {    // 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) {  // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {                        // 第二次来到cur
                    mostRight.right = null;
                }
            }
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    /**
     * morris后序遍历
     */
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;   // mostRight是cur左孩子
            if (mostRight != null) {    // 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) {  // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {                        // 第二次来到cur
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    // 以X为头的树，逆序打印它的右边界
    public static void printEdge(Node x) {
        Node tail = reverseEdge(x);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + "");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    // 逆序from为头的右子树
    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    /**
     * 是否是搜索二叉树的判断，中序遍历为递增或递减的树
     */
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Node cur = head;
        Node mostRight;
        int preValue = Integer.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;   // mostRight是cur左孩子
            if (mostRight != null) {    // 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) {  // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {                        // 第二次来到cur
                    mostRight.right = null;
                }
            }
            if (preValue >= cur.value) {
                return false;
            }
            preValue = cur.value;
            cur = cur.right;
        }
        return true;
    }

}
