package day04;

import common.SingleNode;

/**
 * 将链表中节点的值与一个数值进行比对，比数值小的放在链表左侧，相等的放在中间，大的放在链表右侧
 */
public class SmallerEqualBigger {
    public static SingleNode<Integer> listPartition(SingleNode<Integer> head, int pivot) {
        SingleNode<Integer> SH = null;      //small head
        SingleNode<Integer> ST = null;      //small tail
        SingleNode<Integer> EH = null;      //equal head
        SingleNode<Integer> ET = null;      //equal tail
        SingleNode<Integer> MH = null;      //big head
        SingleNode<Integer> MT = null;      //big tail
        SingleNode<Integer> next = null;    //save next node

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (ST == null) {
                    SH = head;
                    ST = head;
                } else {
                    ST.next = head;
                    ST = head;
                }
            } else if (head.value == pivot) {
                if (ET == null) {
                    EH = head;
                    ET = head;
                } else {
                    ET.next = head;
                    ET = head;
                }
            } else {
                if (MT == null) {
                    MH = head;
                    MT = head;
                } else {
                    MT.next = head;
                    MT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (ST != null) {
            ST.next = EH;
            ET = ET == null ? ST : ET;  //下一步，谁去连大于区的头，谁就变成ET
        }
        if (ET != null) {
            ET.next = MH;
        }
        return SH == null ? (EH == null ? MH : EH) : SH;

    }
}
