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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        
        ListNode res = curr.next;
        while(curr != null && curr.next != null){
            ListNode next = curr.next;
            ListNode sNext = curr.next.next;
            
            next.next = curr;
            if(prev != null)
                prev.next = next;
            prev = curr;
            
            curr = sNext;
        }
        if(curr != null)
            prev.next = curr;
        else
            prev.next = null;
            
        return res;
    }
}