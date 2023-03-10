package day05;

import common.SingleNode;

/**
 * 有两条单链表，它们可能有环，也可能无环
 * 找出它们相交的第一个节点，如果没有，返回null
 */
public class FindFirstIntersectNode {

    // 找到链表的第一个入环点，如果无环，返回null
    public static SingleNode<Integer> getLoopNode(SingleNode<Integer> head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        //先移动一步，使快慢指针能进入下列循环
        SingleNode<Integer> fast = head.next.next;
        SingleNode<Integer> slow = head.next;
        while (fast != slow){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //两点相遇，将fast指向头部，步进改为1，再次相遇时，为入环点
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    //如果两条链表无环，找它们是否相交
    public static SingleNode<Integer> noLoop(SingleNode<Integer> head1, SingleNode<Integer> head2){
        if (head1 == null || head2 == null){
            return null;
        }

        SingleNode<Integer> cur1 = head1;
        SingleNode<Integer> cur2 = head2;

        int list1Length = 1;
        int list2Length = 1;

        // 找到两条链表的最后一个节点及链表长度，比较它们是否相等
        while (cur1.next != null){
            list1Length++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            list2Length++;
            cur2 = cur2.next;
        }
        // 如果相等说明相交，不等说明没相交，返回null
        if (cur1 != cur2){
            return null;
        }
        cur1 = list1Length >= list2Length ? head1 : head2;  // 将长度长的链表给cur1
        cur2 = cur1 == head1 ? head2 : head1;               // 将长度短的链表给cur2

        for (int i = 0; i < Math.abs(list1Length-list2Length); i++) {
            cur1 = cur1.next;
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


}
