package completed.code104;

class Solution {

    int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        inOrder(root, 1);
        return max;
    }

    public void inOrder(TreeNode root, int level) {
        if (root == null) return;
        if (level > max) max = level;
        inOrder(root.left, level + 1);
        inOrder(root.right, level + 1);
    }
}