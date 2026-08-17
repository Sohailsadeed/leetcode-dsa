/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = new ListNode(-1);
        fast.next = head;
        ListNode slow = new ListNode(-1);
        slow.next = head;
        fast = fast.next.next;
        slow = slow.next;
        while (fast != null && fast.next != null) {
            if (fast.next == slow || fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}