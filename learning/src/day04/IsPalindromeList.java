package day04;

import common.SingleNode;

/**
 * 验证单链表是否为回文链表
 */
public class IsPalindromeList {

    public static boolean isPalindrome3(SingleNode head){
        if (head == null || head.next == null){
            return true;
        }
        SingleNode n1 = head;
        SingleNode n2 = head;

        while (n2.next != null && n2.next.next != null){    // find mid node
            n1 = n1.next;       // n1->mid
            n2 = n2.next.next;  // n2->end
        }
        n2 = n1.next;           // n2 -> right part first node
        n1.next = null;         // mid.next -> null
        SingleNode n3 = null;
        while (n2 != null) {    // right part convert
            n3 = n2.next;       // n3 -> save
            n2.next = n1;       // next of right node convert
            n1 = n2;            // n1 move
            n2 = n3;            // n2 move
        }
        n3 = n1;                // n3 -> save last node
        n2 = head;              // n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) {  // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;       // left to mid
            n2 = n2.next;       // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {    // recover
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
