package day06;

import day05.TreeNode;

import java.util.*;

public class JudgeTree {
    // 判断一棵树是不是搜索二叉树（递归
    public static int preValue = Integer.MIN_VALUE;
    public static boolean isBST(TreeNode<Integer> head) {
        if (head == null) {
            return true;
        }
        boolean isBst = isBST(head.left);
        if (!isBst) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }

        return isBST(head.right);
    }

    // 判断一棵树是不是搜索二叉树（无递归
    public static boolean isBSTUnRecur(TreeNode<Integer> head) {
        if (head == null) {
            return true;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        int preValue = Integer.MIN_VALUE;

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value <= preValue) {
                    return false;
                } else {
                    preValue = head.value;
                }
                head = head.right;
            }
        }
        return true;
    }

    // 判断一棵树是不是完全二叉树
    public static boolean isCBT(TreeNode<Integer> head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(head);

        boolean leafFlag = false;
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (
                    (leafFlag && (head.left != null || head.right != null))
                            ||
                            (head.left == null && head.right != null)
            ) {
                return false;
            }
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
            if (head.left == null || head.right == null) {
                leafFlag = true;
            }
        }
        return true;
    }

    // ========== 判断一棵树是不是平衡二叉树 ============
    public static class ReturnType1 {
        public boolean isBT;
        public int height;

        public ReturnType1(boolean isBT, int height) {
            this.isBT = isBT;
            this.height = height;
        }
    }

    public static boolean isBalanced(TreeNode<Integer> head) {
        return process1(head).isBT;
    }

    public static ReturnType1 process1(TreeNode<Integer> head) {
        if (head == null) {
            return new ReturnType1(true, 0);
        }

        ReturnType1 leftReturn = process1(head.left);
        ReturnType1 rightReturn = process1(head.right);
        int curHeight = Math.max(leftReturn.height, rightReturn.height) + 1;
        boolean isBT = leftReturn.isBT && rightReturn.isBT && Math.abs(leftReturn.height - rightReturn.height) < 2;
        return new ReturnType1(isBT, curHeight);
    }
    // =========================================

    // ========== 判断一棵树是不是搜索二叉树 ==========
    public static class ReturnType2{
        public boolean isBST;
        public int min;
        public int max;

        public ReturnType2(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean isSeachTree(TreeNode<Integer> head){
        return process2(head).isBST;
    }

    public static ReturnType2 process2(TreeNode<Integer> head) {
        if (head == null) {
            return null;
        }
        ReturnType2 leftReturn = process2(head);
        ReturnType2 rightReturn = process2(head);
        int min = head.value;
        int max = head.value;
        if (leftReturn != null) {
            min = Math.min(min, leftReturn.min);
            max = Math.max(max, leftReturn.max);
        }
        if (rightReturn != null) {
            min = Math.min(min, rightReturn.min);
            max = Math.max(max, rightReturn.max);
        }
        boolean isBST = true;
        if (leftReturn != null && (!leftReturn.isBST || leftReturn.max >= head.value)) {
            isBST = false;
        }
        if (rightReturn != null && (!rightReturn.isBST || rightReturn.min <= head.value)) {
            isBST = false;
        }
        return new ReturnType2(isBST, min, max);
    }
    // ==========================================

    // =========== 判断一棵树是不是满二叉树 ===========
    public static boolean isFBT(TreeNode<Integer> head) {
        if (head == null) {
            return true;
        }
        ReturnType3 returnType3 = process3(head);
        return returnType3.nodeNum == ((1 << returnType3.height) - 1);
    }

    public static class ReturnType3{
        public int height;
        public int nodeNum;

        public ReturnType3(int height, int nodeNum) {
            this.height = height;
            this.nodeNum = nodeNum;
        }
    }

    public static ReturnType3 process3(TreeNode<Integer> head) {
        if (head == null) {
            return new ReturnType3(0, 0);
        }

        ReturnType3 leftReturn = process3(head.left);
        ReturnType3 rightReturn = process3(head.right);

        int height = Math.max(leftReturn.height, rightReturn.height) + 1;
        int nodeNum = leftReturn.nodeNum + rightReturn.nodeNum + 1;
        return new ReturnType3(height, nodeNum);
    }

    // ===========================================


    // ======== 给定两个树节点，找到这两个节点的最低公共祖先 ========
    // 限制：node1、node2一定属于head树
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> head, TreeNode<Integer> node1, TreeNode<Integer> node2) {
        HashMap<TreeNode<Integer>, TreeNode<Integer>> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        findFatherProcess(head, fatherMap);
        HashSet<TreeNode<Integer>> node1set = new HashSet<>();
        TreeNode<Integer> cur = node1;
        while (cur != fatherMap.get(cur)) {
            node1set.add(cur);
            cur = fatherMap.get(cur);
        }
        node1set.add(cur);

        cur = node2;
        while (!node1set.contains(cur)) {
            cur = fatherMap.get(cur);
        }
        return cur;
    }

    public static void findFatherProcess(TreeNode<Integer> head, HashMap<TreeNode<Integer>, TreeNode<Integer>> fatherMap) {
        if (head == null) {
            return;
        }
        if (head.left != null) {
            fatherMap.put(head.left, head);
        }
        if (head.right != null) {
            fatherMap.put(head.right, head);
        }
        findFatherProcess(head.left, fatherMap);
        findFatherProcess(head.right, fatherMap);
    }
    // =============================================

    // ======== 给定两个树节点，找到这两个节点的最低公共祖先(方法2) ========
    public static TreeNode<Integer> lowerAncestor(TreeNode<Integer> head, TreeNode<Integer> o1, TreeNode<Integer> o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        TreeNode<Integer> left = lowerAncestor(head.left, o1, o2);
        TreeNode<Integer> right = lowerAncestor(head.right, o1, o2);

        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
}
