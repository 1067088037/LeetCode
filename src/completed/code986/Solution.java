package completed.code986;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        final int m = firstList.length, n = secondList.length;

        List<int[]> list = new LinkedList<>();

        while (i < m && j < n) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) list.add(new int[]{start, end});

            if (firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
