package day04;

import common.RandNode;

import java.util.HashMap;

/**
 * 有一个链表，它的节点上不仅有指向下一节点的指针，还有一个指向随机位置（可以为null）的指针
 * 现在要将这样一个链表的结构进行复制，要如何操作
 */
public class CopyListWithRandom {

    /**
     * 通过辅助hashmap，将原始节点和复制节点作为一对(key,value)存入hashmap中
     * 然后通过再次遍历时的对应关系，将value进行串联
     */
    public static RandNode<Integer> copyListWithRandom1(RandNode<Integer> head) {
        HashMap<RandNode<Integer>, RandNode<Integer>> map = new HashMap<>();
        RandNode<Integer> node = head;
        while (node != null) {
            map.put(node, new RandNode<>(node.value));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).rand = map.get(node.rand);
            node = node.next;
        }
        return map.get(head);
    }

    /**
     * 通过先将链表的复制节点与原节点连接
     * 例如：原链表：1 -> 2 -> 3 -> ...
     *      扩展后：1 -> 1` -> 2 -> 2` -> 3 -> 3` -> ...
     * 这样就拥有了特殊的位置关系，可以利用特殊的位置关系对rand节点进行赋值
     * 时间复杂度O(N),空间复杂度O(1)
     */
    public static RandNode<Integer> copyListWithRandom2(RandNode<Integer> head) {
        if (head == null){
            return head;
        }
        RandNode<Integer> cur = head;
        RandNode<Integer> next = null;

        //先进行复制扩展
        while (cur != null) {
            next = cur.next;
            cur.next = new RandNode<>(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        //复制原链表的rand指针
        while(cur != null) {
            cur.next.rand = cur.rand != null ? cur.rand.next : null;
            cur = cur.next.next;
        }

        //提取出复制的链表
        cur = head;
        RandNode<Integer> res = head.next;
        while (cur != null) {
            next = cur.next.next;
            cur.next = next;
            cur.next.next = next == null ? null : next.next;
            cur = next;
        }

        return res;

    }
}
