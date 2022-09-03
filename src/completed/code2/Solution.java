package completed.code2;

import java.util.Objects;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode lastButOne = null;
        ListNode first = node;
        while (l1 != null || l2 != null) {
            int sum, carry = 0;
            if (l1 != null && l2 != null) {
                sum = (l1.val + l2.val) % 10;
                carry = (l1.val + l2.val) / 10;
            } else sum = Objects.requireNonNullElse(l1, l2).val;

            node.val += sum;
            if (node.val >= 10) {
                node.val -= 10;
                carry++;
            }
            ListNode next = new ListNode(carry, null);
            node.next = next;
            lastButOne = node;
            node = next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (node.val == 0 && lastButOne != null) lastButOne.next = null;

        return first;
    }
}