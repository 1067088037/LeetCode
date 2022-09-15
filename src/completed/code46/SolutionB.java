package completed.code46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SolutionB {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public void backtrack(List<Integer> temp, int[] nums, boolean[] vis) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            temp.add(nums[i]);
            backtrack(temp, nums, vis);
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }

}