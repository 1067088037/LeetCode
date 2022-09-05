package completed.code652;

import java.util.*;

class Solution {

    HashMap<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> ret = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preorder(root);
        return new ArrayList<>(ret);
    }

    public String preorder(TreeNode root) {
        if (root == null) return "null";

        String s = root.val + "[" +
                preorder(root.left) + "][" +
                preorder(root.right) + "]";
        if (map.containsKey(s)) {
            ret.add(map.get(s));
        } else {
            map.put(s, root);
        }

        return s;
    }
}