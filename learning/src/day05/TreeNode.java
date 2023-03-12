package day05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode <T>{
    public T value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    // 先序遍历递归版
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 中序遍历递归版
    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    // 后序遍历递归版
    public static void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    // 先序遍历无递归版
    public static void preOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print("preorder : ");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    // 中序遍历无递归版
    public static void inOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print("inorder : ");
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    // 后序遍历无递归版
    public static void posOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        System.out.print("posOrder : ");
        stack1.add(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    // 宽度优先遍历
    public static void widthSearch(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // 查询树的最大宽度
    public static int findMaxWidth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevelNum = 0;
        int curLevel = 1;
        int maxWidth = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (levelMap.get(node) == curLevel) {
                curLevelNum += 1;
            } else {
                maxWidth = Math.max(maxWidth, curLevelNum);
                curLevelNum = 1;
                curLevel += 1;
            }

            if (node.left != null) {
                queue.add(node.left);
                levelMap.put(node.left, curLevel + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                levelMap.put(node.right, curLevel + 1);
            }
        }
        return maxWidth;
    }

    // 查询树的最大宽度（无hashmap版
    public static int findMaxWidth2(TreeNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(head);
        TreeNode<Integer> curlast = head;       // 记录当前层最后一个节点
        TreeNode<Integer> nextlast = null;      // 记录下一层最后一个节点
        int curLevelNum = 0;                    // 记录当前层的总节点数
        int maxNum = Integer.MIN_VALUE;         // 记录树的最大层宽度
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            curLevelNum++;
            // 在将下一层节点加入队列的同时，依序标记遇到的下一层节点记作nextlast
            if (node.left != null) {
                queue.add(node.left);
                nextlast = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextlast = node.right;
            }
            if (node == curlast) {  // 如果当前层走到最后一个节点了
                // 比较当前层节点数与之前记录的最大层宽度
                maxNum = Math.max(maxNum, curLevelNum);
                // 下一个节点就要进入下一层了，所以要将下一层最后一个节点提上来设为当前层最后一个节点，以备使用
                curlast = nextlast;
                // 重新计数
                curLevelNum = 0;
            }
        }
        return maxNum;
    }





}
