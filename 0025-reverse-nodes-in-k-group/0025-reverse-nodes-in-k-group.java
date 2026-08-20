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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        ListNode curr = head;
        ListNode newHead = null;
        ListNode prevGroupTail = null;
        while(curr != null){
            ListNode temp = curr;
            int count = 0;

            while(temp != null && count < k){
                temp = temp.next;
                count++;
            }
            if(count < k){
                if(prevGroupTail != null){
                    prevGroupTail.next = curr;
                    break;
                }
            }
            count = 0;
            ListNode currGroupHead = curr;
            ListNode prev = null;
            while(curr != null && count < k){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            if(newHead == null)
                newHead = prev;
            else
                prevGroupTail.next = prev;
            prevGroupTail = currGroupHead;
        }
        return newHead;
    }
}