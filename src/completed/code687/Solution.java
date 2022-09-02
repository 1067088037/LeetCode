package completed.code687;

class Solution {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);

        int countLeft = 0, countRight = 0;
        if (node.left != null && node.left.val == node.val)
            countLeft = left + 1;
        if (node.right != null && node.right.val == node.val)
            countRight = right + 1;

        max = Math.max(max, countLeft + countRight);
        return Math.max(countLeft, countRight);
    }
}