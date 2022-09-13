package completed.code206;

import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        if (stack.isEmpty()) return null;
        ListNode newHead = stack.peek();
        stack.pop();
        node = newHead;
        while (!stack.isEmpty()) {
            node.next = new ListNode(stack.pop().val);
            node = node.next;
        }
        return newHead;
    }
}