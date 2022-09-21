package code1926;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] maze = new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        solution.nearestExit(maze, new int[]{1, 2});
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];

        int count = 0;
        Queue<int[]> queue;
        Queue<int[]> next = new LinkedList<>();
        next.offer(new int[]{entrance[0], entrance[1]});
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        while (!next.isEmpty()) {
            count++;
            queue = next;
            next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                if (x < 0 || y < 0 || x >= m || y >= n) {
                    ans.offer(count);
                    continue;
                }
                if (vis[x][y]) continue;
                vis[x][y] = true;
                if (maze[x][y] == '+') continue;
                for (int i = 0; i < 4; i++) {
                    int x1 = x + dir[i][0], y1 = y + dir[i][1];
                    next.offer(new int[]{x1, y1});
                }
            }
        }

        return ans.isEmpty() ? -1 : ans.peek();
    }
}
