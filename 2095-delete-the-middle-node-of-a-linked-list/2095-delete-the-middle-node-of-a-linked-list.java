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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null)    return null;
        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next;
        ListNode prev = slow;
        if(fast == null)
            return null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(fast != null){
            prev = slow;
            slow = slow.next;
        }  
        prev.next = slow.next;
        return head;
    }
}