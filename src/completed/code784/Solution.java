package completed.code784;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<StringBuilder> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        res.add(new StringBuilder());

        for (char c : chars) {
            int n = res.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    res.add(new StringBuilder(res.get(i)));
                    res.get(i).append(Character.toLowerCase(c));
                    res.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (StringBuilder re : res) {
                    re.append(c);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (StringBuilder re : res) {
            ans.add(re.toString());
        }
        return ans;
    }
}