package completed.code144;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private final List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        result.clear();
        preOrder(root);
        return result;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}