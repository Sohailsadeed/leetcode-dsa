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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(fast != null){
            prev = slow;
            slow = slow.next;
        }   
        ListNode localPrev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = localPrev;
            localPrev = slow;
            slow = next;
        }
        prev.next = localPrev;
        slow = head;
        fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(fast != null){
            prev = slow;
            slow = slow.next;
        } 

        ListNode temp = head;
        prev = null;
        ListNode firstNode = slow;
        while(temp != firstNode){
            ListNode next = temp.next;
            temp.next = slow;
            if(prev != null)
                prev.next = temp;

            prev = slow;
            temp = next;
            if(slow != null)
                slow = slow.next;
        }   
    }
}