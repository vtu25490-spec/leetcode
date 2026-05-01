class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // Start DFS when land is found
                if (grid[i][j] == 1) {

                    int area = dfs(grid, i, j);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Invalid cell or water
        if (r < 0 || r >= rows ||
            c < 0 || c >= cols ||
            grid[r][c] == 0) {

            return 0;
        }

        // Mark as visited
        grid[r][c] = 0;

        // Count current cell + 4 directions
        return 1
                + dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }
}