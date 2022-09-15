package completed.code653;

import java.util.HashSet;

class Solution {

    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(root.val)) return true;
        set.add(k - root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}