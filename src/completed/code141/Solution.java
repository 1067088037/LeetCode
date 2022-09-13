package completed.code141;

import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode node = head;
        listNodes.add(node);
        while (node != null && node.next != null) {
            node = node.next;
            if (listNodes.contains(node)) {
                return true;
            } else {
                listNodes.add(node);
            }
        }
        return false;
    }
}
