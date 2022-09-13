package completed.code145;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        result.clear();
        preOrder(root);
        return result;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        result.add(root.val);
    }
}