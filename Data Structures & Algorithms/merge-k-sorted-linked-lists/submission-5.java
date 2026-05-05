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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            q.offer(node);
        }

        while (!q.isEmpty()) {
            ListNode node = q.poll();

            if (node != null) {
                curr.next = node;
                curr = curr.next;

                if (node.next != null) {
                    q.offer(node.next);
                }
            }
        }

        return dummy.next;
    }
}
