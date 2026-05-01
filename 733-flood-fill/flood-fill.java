class Solution {

    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int color) {

        int originalColor = image[sr][sc];

        // If color is same, no need to process
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image,
                     int r,
                     int c,
                     int originalColor,
                     int newColor) {

        int rows = image.length;
        int cols = image[0].length;

        // Invalid cell or different color
        if (r < 0 || r >= rows ||
            c < 0 || c >= cols ||
            image[r][c] != originalColor) {

            return;
        }

        // Change color
        image[r][c] = newColor;

        // Visit 4 directions
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
    }
}