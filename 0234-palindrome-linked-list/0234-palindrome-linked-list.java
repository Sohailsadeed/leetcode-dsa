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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode fast = new ListNode(-1);
        fast.next = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        boolean odd = true;
        if(fast != null){
            slow = slow.next;
            odd = false;
        }
        
        ListNode curr = slow;
        ListNode prev = null;
        ListNode next = null;
        if(odd)
            curr = curr.next;
            
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode reversed = prev;
        
        while(reversed != null){
            if(temp.val != reversed.val)
                return false;
            temp = temp.next;
            reversed = reversed.next;
        }
        return true; 
    }
}