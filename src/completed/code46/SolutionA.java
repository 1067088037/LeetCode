package completed.code46;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class SolutionA {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        dfs(Arrays.stream(nums).boxed().collect(Collectors.toList()), new LinkedList<>());
        return result;
    }

    public void dfs(List<Integer> nums, List<Integer> ans) {
        if (nums.size() == 0) {
            result.add(ans);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            LinkedList<Integer> newNums = new LinkedList<>(nums);
            newNums.remove(nums.get(i));
            LinkedList<Integer> res = new LinkedList<>(ans);
            res.add(nums.get(i));
            dfs(newNums, res);
        }
    }

}