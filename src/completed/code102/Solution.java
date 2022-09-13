package completed.code102;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        ret.clear();
        ret.add(null);
        inOrder(root, 1);
        ret.remove(0);
        return ret;
    }

    public void inOrder(TreeNode root, int level) {
        if (root == null) return;
        if (ret.size() - 1 < level) ret.add(new ArrayList<>());

        inOrder(root.left, level + 1);
        ret.get(level).add(root.val);
        inOrder(root.right, level + 1);
    }
}