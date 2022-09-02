package completed.code687;

public class LeetCode687 {
    public static void main(String[] args) {
        int[] tree = new int[]{5, 4, 5, 1, 1, 5};
        TreeNode root = buildTree(0, tree);
        System.out.println(root);
    }

    public static TreeNode buildTree(int index, int[] nums) {
        if (index > nums.length - 1) return null;
        TreeNode node = new TreeNode(nums[index]);
        node.left = buildTree(index * 2 + 1, nums);
        node.right = buildTree(index * 2 + 2, nums);
        return node;
    }
}



