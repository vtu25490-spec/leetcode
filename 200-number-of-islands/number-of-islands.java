class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // Found an island
                if (grid[i][j] == '1') {

                    dfs(grid, i, j);

                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Invalid cell or water
        if (r < 0 || r >= rows ||
            c < 0 || c >= cols ||
            grid[r][c] == '0') {

            return;
        }

        // Mark as visited
        grid[r][c] = '0';

        // Visit all 4 directions
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}