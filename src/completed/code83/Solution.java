package completed.code83;

import java.util.HashSet;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode node = head.next;
        ListNode last = head;
        while (node != null) {
            if (set.contains(node.val)) {
                last.next = node.next;
            } else {
                set.add(node.val);
                last = node;
            }
            node = node.next;
        }
        return head;
    }
}