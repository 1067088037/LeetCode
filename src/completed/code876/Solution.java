package completed.code876;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        int count = 1;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        for (int i = 0; i < count / 2; i++) {
            head = head.next;
        }
        return head;
    }
}