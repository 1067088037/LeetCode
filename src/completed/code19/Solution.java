package completed.code19;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int count = 1;
        while (node.next != null) {
            count++;
            node = node.next;
        }

        if (count == 1) return null;

        if (count == n) {
            node = head.next;
            head.next = null;
            return node;
        }

        node = head;
        for (int i = 0; i < count - n - 1; i++) {
            node = node.next;
        }
        node.next = node.next.next;

        return head;
    }
}