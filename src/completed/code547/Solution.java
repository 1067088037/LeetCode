package completed.code547;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if (n == 1) return 1;
        boolean[] vis = new boolean[n];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (true) {
            count++;
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (int i = 0; i < n; i++) {
                    if (!vis[i] && isConnected[poll][i] == 1) {
                        vis[i] = true;
                        queue.offer(i);
                    }
                }
            }
            int notVis = getNotVis(vis);
            if (notVis == -1) break;
            else queue.offer(notVis);
        }
        return count;
    }

    private int getNotVis(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) return i;
        }
        return -1;
    }
}