package completed.code203;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        var ret = solution.removeElements(node, 2);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode node = head.next;
        ListNode last = head;
        while (node != null) {
            if (node.val == val) {
                last.next = node.next;
            } else last = node;
            node = node.next;
        }

        while (head != null) {
            if (head.val == val) head = head.next;
            else return head;
        }
        return null;
    }
}