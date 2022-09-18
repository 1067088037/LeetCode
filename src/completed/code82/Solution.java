package completed.code82;

import java.util.HashSet;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        head = new ListNode(0, head);
        ListNode last = head;
        HashSet<Integer> set = new HashSet<>();

        while (node != null) {
            if (set.contains(node.val)) {
                last.next = node.next;
                node = last.next;
                continue;
            }
            if (node.next != null && node.next.val == node.val) {
                set.add(node.val);
                last.next = node.next.next;
                node = last.next;
            } else {
                last = node;
                node = node.next;
            }
        }

        return head.next;
    }
}