package completed.code118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>(numRows);
        List<Integer> last = null;
        for (int i = 0; i < numRows; i++) {
            int level = i + 1;
            List<Integer> list = new ArrayList<>(level);
            list.add(1);
            for (int j = 1; j < level - 1; j++) {
                list.add(last.get(j - 1) + last.get(j));
            }
            if (level != 1) list.add(1);
            ret.add(list);
            last = list;
        }
        return ret;
    }
}