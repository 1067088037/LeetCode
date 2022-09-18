package completed.code6182;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root.left == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        boolean isOdd = true;
        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            List<Integer> nums = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll == null) break;
                level.add(poll);
                nums.add(poll.val);
            }
            if (isOdd) {
                for (int i = 0; i < level.size(); i++) {
                    level.get(i).val = nums.get(nums.size() - i - 1);
                }
            }
            for (TreeNode treeNode : level) {
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
            }
            isOdd = !isOdd;
        }

        return root;
    }
}