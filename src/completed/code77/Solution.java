package completed.code77;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        getCombine(1, n, k, new LinkedList<>());
        return ans;
    }

    public void getCombine(int start, int n, int k, List<Integer> list) {
        if (k == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            getCombine(i + 1, n, k - 1, list);
            list.remove(list.size() - 1);
        }
    }
}