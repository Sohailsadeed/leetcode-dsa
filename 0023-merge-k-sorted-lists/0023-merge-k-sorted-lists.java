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

import java.util.PriorityQueue;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode list : lists)
            if(list != null)
                pq.add(list);

        ListNode dummyNode = new ListNode(-1, null);
        ListNode temp = dummyNode;
        while(!pq.isEmpty()){
            ListNode top = pq.poll();

            temp.next = top;
            temp = temp.next;

            if(top.next != null)
                pq.add(top.next);
        }

        return dummyNode.next;
    }
}