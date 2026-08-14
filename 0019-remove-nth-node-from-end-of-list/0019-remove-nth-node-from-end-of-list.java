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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)    
            return null;
        ListNode fast = new ListNode(-1, head);
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        for(int i = 0; i < n; i++)
            fast = fast.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next.next;
        slow.next = temp;
        
        return dummy.next;
    }
}