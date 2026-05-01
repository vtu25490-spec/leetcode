import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Count fresh oranges and add rotten oranges to queue
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;

        // Directions: up, down, left, right
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        // BFS
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int r = current[0];
                int c = current[1];

                for (int[] d : directions) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Valid fresh orange
                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        queue.offer(new int[]{nr, nc});

                        rottenThisMinute = true;
                    }
                }
            }

            if (rottenThisMinute) {
                minutes++;
            }
        }

        // If fresh oranges remain
        return (fresh == 0) ? minutes : -1;
    }
}