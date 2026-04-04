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
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            q.offer(list);
        }

        ListNode root = new ListNode();
        ListNode cur = root;

        while (!q.isEmpty()) {
            ListNode next = q.poll();

            if (next != null) {
                cur.next = next;
                cur = cur.next;
                
                if (next.next != null) {
                    q.offer(next.next);
                }
            }
        }

        return root.next;

    }
}
