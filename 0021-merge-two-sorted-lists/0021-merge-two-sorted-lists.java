/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        ListNode prev = null;
        ListNode res = null;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                if (prev != null) {
                    prev.next = temp1;
                    prev = prev.next;
                } else {
                    prev = temp1;
                    res = prev;
                }
                temp1 = temp1.next;
            } else {
                if (prev != null) {
                    prev.next = temp2;
                    prev = prev.next;
                } else {
                    prev = temp2;
                    res = prev;
                }
                temp2 = temp2.next;
            }
        }

        while (temp2 != null) {
            prev.next = temp2;
            prev = prev.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            prev.next = temp1;
            prev = prev.next;
            temp1 = temp1.next;
        }
        return res;
    }
}