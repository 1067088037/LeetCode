package completed.code21;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                node.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            node = node.next;
        }

        while (list1 != null) {
            node.next = new ListNode(list1.val);
            list1 = list1.next;
            node = node.next;
        }
        while (list2 != null) {
            node.next = new ListNode(list2.val);
            list2 = list2.next;
            node = node.next;
        }

        return head.next;
    }
}