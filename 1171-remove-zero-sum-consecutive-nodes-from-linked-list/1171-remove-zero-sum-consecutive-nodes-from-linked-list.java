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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)
            return null;
         ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        ArrayList<ListNode> list = new ArrayList<>();

        while (curr != null) {

            list.add(curr);

            int localSum = 0;
            int i = list.size() - 1;

            while (i >= 0) {

                localSum += list.get(i).val;

                if (localSum == 0) {

                    ListNode next = curr.next;

                    // Zero-sum sequence starts from the first
                    // node in ArrayList
                    if (i == 0) {

                        prev.next = next;

                        list.clear();

                    } else {

                        // Node just before the zero-sum sequence
                        ListNode before = list.get(i - 1);

                        // Skip the zero-sum nodes
                        before.next = next;

                        // Remove zero-sum nodes from ArrayList
                        while (list.size() > i) {
                            list.remove(list.size() - 1);
                        }

                        // prev remains unchanged
                    }

                    break;
                }

                i--;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}