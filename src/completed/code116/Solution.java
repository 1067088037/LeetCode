package completed.code116;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public Queue<Node> queue = new LinkedList<>();

    public Node connect(Node root) {
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node node = queue.peek();
            for (int i = 1; i < size; i++) {
                node.next = (Node) ((LinkedList<?>) queue).get(i);
                node = node.next;
            }
            for (int i = 0; i < size; i++) {
                Node peek = queue.peek();
                assert peek != null;
                if (peek.left != null)
                    queue.add(peek.left);
                if (peek.right != null)
                    queue.add(peek.right);
                queue.remove(peek);
            }
        }
        return root;
    }

}