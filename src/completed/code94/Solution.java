package completed.code94;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        result.clear();
        preOrder(root);
        return result;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);
        result.add(root.val);
        preOrder(root.right);
    }
}