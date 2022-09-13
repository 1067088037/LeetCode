package completed.code733;

class Solution {

    boolean[][] vis;
    int[] offsetX = {0, 0, 1, -1};
    int[] offsetY = {1, -1, 0, 0};
    int initColor = -1;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        vis = new boolean[image.length][image[0].length];
        initColor = image[sr][sc];
        fill(image, sr, sc, color);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;
        if (vis[sr][sc]) return;
        vis[sr][sc] = true;
        if (image[sr][sc] != initColor) return;
        image[sr][sc] = color;
        for (int i = 0; i < 4; i++) {
            fill(image, sr + offsetX[i], sc + offsetY[i], color);
        }
    }
}