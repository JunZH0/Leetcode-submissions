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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int first = (l1 != null) ? l1.val : 0;
            int second = (l2 != null) ? l2.val : 0;

            int sum = first + second + carry;
            carry = sum / 10;
            int digit = sum % 10;
            node.next = new ListNode(digit);
            node = node.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }
}
