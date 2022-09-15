package completed.code112;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum);
    }

    public boolean pathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null)
            return targetSum == root.val;
        return pathSum(root.left, targetSum - root.val)
                || pathSum(root.right, targetSum - root.val);
    }
}